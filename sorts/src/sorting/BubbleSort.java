package sorting;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 5:15 PM
 */
public class BubbleSort {

    // Best Case Comparison: O(n) - already sorted list, Swaps: O(1)
    // Avg Case Comparisons & Swaps: O(n^2)
    // Worst Case Comparisons & Swaps: O(n^2) - reversed list (sorted in reverse)
    // Size O(1)
    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * @param args command line arguements
     */
    public static void main(String[] args) {
        int[] testArray = {5, 1234, 0, 97, 10, -1, 999, 2, 542, 1, 23, 105, 876, 615, 64};

        System.out.println("BubbleSort INPUT Unsorted : " + Arrays.toString(testArray));
        bubbleSort(testArray);   // Sort the Array
        System.out.println("BubbleSort OUTPUT Sorted  : " + Arrays.toString(testArray));

    }
}
