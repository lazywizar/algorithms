package com.thinklazy;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int[] a = {2, 5, 7, 1, 9, 5, 23};
        // int[] a = { 2, 7, 1 };

        // quickSort(a, 0, a.length - 1);
        quickSortWithPartition(a, 0, a.length - 1);
        // quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] A, int left, int right) {
        if (left >= right)
            return;

        int i = left;
        int j = right;
        int pivot = A[left + (right - left) / 2];

        while (i <= j) {
            while (A[i] < pivot) {
                i++;
            }
            while (A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }

        quickSort(A, left, j);
        quickSort(A, i, right);
    }

    /*
     * 
     * With paartition
     */
    public static void quickSortWithPartition(int[] A, int left, int right) {
        if (left >= right)
            return;

        int pivot = partition(A, left, right);

        quickSortWithPartition(A, left, pivot);
        quickSortWithPartition(A, pivot + 1, right);
    }

    private static int partition(int[] a, int low, int high) {
        int pivotIdx = (high + low) / 2;
        int pivot = a[pivotIdx];
        // Move the index element to last
        swap(a, high, pivotIdx);

        int index = low;
        for (int i = low; i < high; i++) {
            if (a[i] < pivot) {
                swap(a, i, index);
                index++;
            }
        }
        // Move back the index element
        swap(a, index, high);
        return index;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
