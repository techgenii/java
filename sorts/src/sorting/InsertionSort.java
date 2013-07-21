package sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 5:15 PM
 * Good For: Small Arrays
 */
public class InsertionSort {

    // Best Case Comparison: O(n) - already sorted list, Swaps: O(1)
    // Avg Case Comparisons & Swaps: O(n^2)
    // Worst Case Comparisons & Swaps: O(n^2) - reversed list (sorted in reverse)
    // Size O(n)
    public static void insertionSort(int[] arr) {
        int i, j, newValue;

        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }
    }

    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        int[] testArray = {5, 1234, 0, 97, 10, -1, 999, 2, 542, 1, 23, 105, 876, 615, 64};

        System.out.println("InsertionSort INPUT Unsorted : " + Arrays.toString(testArray));
        insertionSort(testArray);   // Sort the Array
        System.out.println("InsertionSort OUTPUT Sorted  : " + Arrays.toString(testArray));

    }
}
