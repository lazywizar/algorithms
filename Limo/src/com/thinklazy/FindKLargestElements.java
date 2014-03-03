package com.thinklazy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKLargestElements {
    public static void main(String args[]) {
        Integer[] a = {2, 5, 7, 1, 9, 5, 23}; // [23, 9, 7, 5, 5, 2, 1]
        int k = 3;
        System.out.println(findKLargestElement(Arrays.asList(a), k - 1));
        // System.out.println(Arrays.toString(findKLargestElement(Arrays.asList(a), k-1)));
    }

    /**
     * Better solution using minHeap O(k + (n-k)logk)
     */
    private static List<Integer> findKLargestElement(List<Integer> a, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        int i = 0;
        while (i <= k) {
            minHeap.add(a.get(i)); // O(k)
            i++;
        }

        // Not insert rest of the n-k elements .. slowly..
        // We are trying to store all k greatest numbers in heap..
        // with min heap telling us which is the smallest among the k largest.
        for (i = k; i < a.size(); i++) {
            if (a.get(i) > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(a.get(i));
            }
        }
        return Arrays.asList(minHeap.toArray(new Integer[k]));
    }


    /**
     * 1) Build a Max Heap tree in O(n) 
     * 2) Use Extract Max k times to get k maximum elements from the Max Heap O(klogn) Time complexity: O(n + klogn)
     * 
     * @param a
     * @param k
     */
    private static void findKLargestElementBad(List<Integer> a, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<Integer>(a.size(), new MaxHeapComperator());
        for (Integer n : a) {
            maxHeap.add(n); // O(n)
        }
        int i = k + 1;
        while (i > 0) { // O(klogn)
            System.out.print(maxHeap.remove() + " ");
            i--;
        }
    }

    public static class MaxHeapComperator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            }
            return 0;
        }

    }



}
