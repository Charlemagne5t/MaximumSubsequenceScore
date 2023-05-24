package org.example;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        quickSort(nums2, nums1);
        int max = 0;
        for (int i = 0; i < nums2.length - k + 1; i++) {
            max = Math.max(max, (maxSum( nums1, i + 1, k - 1) + nums1[i]) * nums2[i]);
        }

        return max;
    }

    private int maxSum(int[] nums1, int index, int k) {
        IntHolder maxSum = new IntHolder(Integer.MIN_VALUE);

        backtrack(nums1, k, index, 0, maxSum);


        return maxSum.value;
    }
    private static void backtrack(int[] array, int k, int start, int currentSum, IntHolder maxSum) {
        if (k == 0) {
            maxSum.value = Math.max(maxSum.value, currentSum);
            return;
        }

        for (int i = start; i < array.length; i++) {
            backtrack(array, k - 1, i + 1, currentSum + array[i], maxSum);
        }
    }

    public void quickSort(int[] array, int[] array1) {
        sort(array,array1, 0, array.length - 1);
    }

    private void sort(int[] array, int[] array1, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(array, array1, low, high);

            sort(array, array1, low, pivotIndex - 1);
            sort(array, array1, pivotIndex + 1, high);

        }
    }

    private int partition(int[] array, int[] array1, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                int temp1 = array1[i];
                array1[i] = array1[j];
                array1[j] = temp1;

            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        int temp1 = array1[i + 1];
        array1[i + 1] = array1[high];
        array1[high] = temp1;

        return i + 1;

    }
}
class IntHolder{
    int value;

    IntHolder(int value) {
        this.value = value;
    }
}
