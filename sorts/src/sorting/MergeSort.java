package sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 5:15 PM
 */
public class MergeSort {

    public static int[] testArray = {5, 1234, 0, 97, 10, -1, 999, 2, 542, 1, 23, 105, 876, 615, 64};
    public static int[] copyArray;

    // Best Case Comparison: O(n log n)
    // Avg Case Comparisons: O(n log n)
    // Worst Case Comparisons: O(n log n)
    // Size O(n)
    /**
     * Merge sort (ascending order)
     * @param start first index, which can be touched
     * @param end last index, which can be touched
     */
    public static void mergeSort(int start, int end) {
        if (start == end) return;
        int middle = (start + end)/2;
        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        merge(start, middle, end);
    }

    /**
     * Merge procedure for merge sort
     * @param start first index, which can be touched
     * @param middle index, which can be touched
     * @param end last index, which can be touched
     */
    private static void merge(int start, int middle, int end) {
        int arrayIndex = start;
        int copyIndex = middle + 1;

        for(int i = start ; i <= end ; i ++)
            copyArray[i] = testArray[i];

        while(copyIndex <= end && arrayIndex <= middle) {
            if(copyArray[arrayIndex] >= copyArray[copyIndex])
                testArray[start++] = copyArray[copyIndex++];
            else
                testArray[start++] = copyArray[arrayIndex++];
        }

        while(arrayIndex <= middle) {
            testArray[start++] = copyArray[arrayIndex++];
        }

        while(copyIndex <= end) {
            testArray[start++] = copyArray[copyIndex++];
        }
    }

    /**
     * @param args command line arguements
     */
    public static void main(String[] args) {

        System.out.println("MergeSort INPUT Unsorted : " + Arrays.toString(testArray));
        copyArray = new int[testArray.length];
        mergeSort(0, testArray.length-1);
        System.out.println("MergeSort OUTPUT Sorted  : " + Arrays.toString(testArray));

    }
}
