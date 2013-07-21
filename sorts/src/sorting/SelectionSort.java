package sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 5:15 PM
  */
public class SelectionSort {

    // Best Case Comparison: O(n^2)
    // Avg Case Comparisons: O(n^2)
    // Worst Case Comparisons: O(n^2)
    // Size O(n)
    public static void selectionSort(int[] arr) {
        int i, j, minIndex, tmp;
        int n = arr.length;

        for (i = 0; i < n - 1; i++) {
            minIndex = i;

            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }

        }

    }

    /**
     * @param args command line arguements
     */
    public static void main(String[] args) {
        int[] testArray = {5, 1234, 0, 97, 10, -1, 999, 2, 542, 1, 23, 105, 876, 615, 64};

        System.out.println("SelectionSort INPUT Unsorted : " + Arrays.toString(testArray));
        selectionSort(testArray);   // Sort the Array
        System.out.println("SelectionnSort OUTPUT Sorted  : " + Arrays.toString(testArray));

    }
}
