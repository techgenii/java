package sorting;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: barbarabickham
 * Date: 7/20/13
 * Time: 5:15 PM
 */
public class BucketSort {

    // Best Case Comparison: O(n log n)
    // Avg Case Comparisons: O(n log n)
    // Worst Case Comparisons: O(n log n)
    // Size O(n)
    /**
     * Bucket sort
     * @param array array to be sorted
     * @param bucketCount number of buckets
     * @return array sorted in ascending order
     */
    @SuppressWarnings("unchecked")
    public static int[] bucketSort(int[] array, int bucketCount) {
        if (bucketCount <= 0) throw new IllegalArgumentException("Invalid bucket count");
        if (array.length <= 1) return array; //trivially sorted

        int high = array[0];
        int low = array[0];
        for (int i = 1; i < array.length; i++) { //find the range of input elements
            if (array[i] > high) high = array[i];
            if (array[i] < low) low = array[i];
        }
        double interval = ((double)(high - low + 1))/bucketCount; //range of one bucket

        ArrayList<Integer> buckets[] = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) { //initialize buckets
            buckets[i] = new ArrayList();
        }

        for (int i = 0; i < array.length; i++) { //partition the input array
            buckets[(int)((array[i] - low)/interval)].add(array[i]);
        }

        int pointer = 0;
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]); //mergeSort
            for (int j = 0; j < buckets[i].size(); j++) { //merge the buckets
                array[pointer] = buckets[i].get(j);
                pointer++;
            }
        }
        return array;
    }

    /**
     * @param args command line args
     */
    public static void main(String[] args) {
        int bucketCount = 3;
        int[] testArray = {5, 1234, 0, 97, 10, -1, 999, 2, 542, 1, 23, 105, 876, 615, 64};
        int[] sortedArray = new int[testArray.length];

        System.out.println("bucketSort INPUT Unsorted : " + Arrays.toString(testArray));
        try {
            sortedArray = bucketSort(testArray, bucketCount);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("bucketSort OUTPUT Sorted  : " + Arrays.toString(sortedArray));

    }
}
