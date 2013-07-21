package sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 5:15 PM
  */
public class QuickSort {

    public static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    // Best Case Comparison: O(n log n)
    // Avg Case Comparisons : O(n log n)
    // Worst Case Comparisons: O(n^2)
    // Size: O(log n)
    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    /**
     * @param args command line arguements
     */
    public static void main(String[] args) {
        int[] testArray = {5, 1234, 0, 97, 10, -1, 999, 2, 542, 1, 23, 105, 876, 615, 64};

        System.out.println("QuickSort INPUT Unsorted : " + Arrays.toString(testArray));
        // Sort the Array, array index from 0 - 15 [rep 1..15]
        quickSort(testArray, 0, 14);
        System.out.println("QuickSort OUTPUT Sorted  : " + Arrays.toString(testArray));

    }
}
