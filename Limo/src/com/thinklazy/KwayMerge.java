package com.thinklazy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KwayMerge {
    public static void main(String args[]) {
        kWayMerge();
    }

    public static void kWayMerge() {
        int BLOCKS = 4; // k
        int TOTAL = 20;
        int count = 0; // k
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(BLOCKS, new NodeComperator());

        List<List<Integer>> blocks = generateKLists();
        for (List<Integer> list : blocks) {
            System.out.print(" OP : " + list);
            System.out.println();
        }

        for (int i = 0; i < BLOCKS; i++) {
            maxHeap.add(new Node(blocks.get(i).remove(0), i));
        }

        while (count < TOTAL) {
            Node top = maxHeap.remove();
            System.out.print(top.value + ","); // can write to file.. or what ever
            count++;
            if (!blocks.get(top.blockNumber).isEmpty()) {
                Node newTop = new Node(blocks.get(top.blockNumber).remove(0), top.blockNumber);
                maxHeap.add(newTop);
            }
        }
    }

    private static class Node {
        public Node(Integer value, Integer blockNumber) {
            this.value = value;
            this.blockNumber = blockNumber;
        }

        Integer value;
        Integer blockNumber;
    }

    private static class NodeComperator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.value > b.value) {
                return -1;
            } else if (a.value < b.value) {
                return 1;
            }
            return 0;
        }
    }

    private static List<List<Integer>> generateKLists() {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        List<Integer> l4 = new ArrayList<Integer>();

        lists.add(fillRandomValues(l1, 5));
        lists.add(fillRandomValues(l2, 5));
        lists.add(fillRandomValues(l3, 5));
        lists.add(fillRandomValues(l4, 5));

        return lists;
    }

    private static List<Integer> fillRandomValues(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            int n = (int) (Math.random() * 100);
            list.add(n);
        }
        Collections.sort(list, new IntReverseComperator());
        return list;
    }

    private static class IntReverseComperator implements Comparator<Integer> {
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
