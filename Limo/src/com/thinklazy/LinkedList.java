package com.thinklazy;


public class LinkedList {

    Node head;

    public LinkedList(int value) {
        head = new Node(value);
        head.next = null;
    }

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            super();
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int value) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node newNode = new Node(value);
        curr.next = newNode;
    }

    public void printLL() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }

    public static void reverseList(LinkedList ll) {
        Node head = ll.head;
        if (head == null || head.next == null) {
            return;
        }

        Node next = head.next;
        Node curr = head;

        curr.next = null;
        Node prev = curr;

        while (next != null) {
            curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
        }
        ll.head = prev;
    }

    public static Node reverse(Node head) {
        // if head is null or only one node, it's reverse of itself.
        if ((head == null) || (head.next == null))
            return head;

        // reverse the sub-list leaving the head node.
        Node reverse = reverse(head.next);

        // head.next still points to the last element of reversed sub-list.
        // so move the head to end.
        head.next.next = head;

        // point last node to nil, (get rid of cycles)
        head.next = null;
        return reverse;
    }


    public static void main(String args[]) {
        LinkedList ll = new LinkedList(4);
        ll.addNode(5);
        ll.addNode(2);
        ll.addNode(7);
        ll.addNode(3);
        
        

        //ll.printLL();
        System.out.println();
        // reverseList(ll);
        //
        reverse(ll.head);
        ll.printLL();

    }

}
