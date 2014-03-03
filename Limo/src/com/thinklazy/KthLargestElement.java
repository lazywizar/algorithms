package com.thinklazy;


public class KthLargestElement {
    public static void main(String args[]) {
        int[] a = {2, 5, 7, 1, 9, 5, 23}; // [23, 9, 7, 5, 5, 2, 1]
        int k = 3;
        int kthLargest = findKthLargestElement(a, k - 1); // k-1 for eliminating 0th largest element
                                                          // as 1st largest element
        System.out.println(kthLargest);
    }

    public static int findKthLargestElement(int[] G, int k) {
        return quickselect(G, 0, G.length - 1, k);
    }

    private static int quickselect(int[] a, int first, int last, int k) {
        if (first <= last) {
            int pivot = partition(a, first, last);
            if (pivot == k) {
                return a[k];
            }
            if (pivot > k) {
                return quickselect(a, first, pivot - 1, k);
            }
            return quickselect(a, pivot + 1, last, k);
        }
        return Integer.MIN_VALUE;
    }


    private static int partition(int[] a, int first, int last) {
        int pivot = first + (int)((Math.random()) * (last - first + 1));
        swap(a, last, pivot);
        int index = first;
        for (int i = first; i < last; i++) {
            if (a[i] > a[last]) {
                swap(a, i, index);
                index++;
            }
        }
        swap(a, index, last);
        return index;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*
     * public static int heapSelect(int[] list, k) { def heap = new PriorityQueue(k) list.each{ item
     * -> if (heap.size() < k || item > heap.peek()) { if (heap.size() == k)
     * heap.remove(heap.peek()) heap.offer(item) } } return heap as List }
     */


}
