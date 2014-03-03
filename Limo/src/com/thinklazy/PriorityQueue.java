package com.thinklazy;

/**
 * The array (or vector) implementation of a binary tree in which the children of a node at position
 * "i" are located at positions "2i+1" and "2i+2" and whose root is at position 0, will be used to
 * implement the complete-heap. This implementation is used because...
 * 
 * The nodes are stored in level order. The next available position for a new node is easy to
 * determine. The last leaf is easily found and removed.
 * 
 * @http://cs.bluecc.edu/java/CS260/Notes/Priority.htm
 * @author varunkumar
 */
public class PriorityQueue {
    Data data[];
    int maxItems, numberOfItems;

    public PriorityQueue(int size) {
        maxItems = size;
        data = new Data[maxItems];
        numberOfItems = 0;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public void insert(Data item) {
        data[numberOfItems] = item;
        trickleUp(numberOfItems);
        ++numberOfItems;
    }

    public Data delete() {
        Data temp = data[0];
        --numberOfItems;
        if (numberOfItems > 0) {
            data[0] = data[numberOfItems];
            trickleDown(0);
        }
        return temp;
    }

    private void trickleUp(int newPosition) {
        Data temp = data[newPosition];
        int parent = (newPosition - 1) / 2;
        while (newPosition > 0 && data[parent].value < temp.value) {
            data[newPosition] = data[parent];
            newPosition = parent;
            parent = (newPosition - 1) / 2;
        }
        data[newPosition] = temp;
    }

    private void trickleDown(int itemPosition) {
        int child; // Index of the larger child.
        if (2 * itemPosition + 1 >= numberOfItems) {
            child = itemPosition; // Leaf node (no children).
        } else if (2 * itemPosition + 2 == numberOfItems) {
            child = 2 * itemPosition + 1; // One child (at the left). //since we have done data[0] =
                                          // data[noOfItems]
        } else if (data[2 * itemPosition + 1].value > data[2 * itemPosition + 2].value) {
            child = 2 * itemPosition + 1; // Two children w/ larger on the left.
        } else {
            child = 2 * itemPosition + 2; // Two children w/ larger on the right.
        }
        if (data[itemPosition].value < data[child].value) {
            Data temp = data[itemPosition];
            data[itemPosition] = data[child];
            data[child] = temp;
            trickleDown(child);
        }
    }

    public class Data {
        int value;
    }
}
