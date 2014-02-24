package com.thinklazy;

import com.thinklazy.LinkedList.NodeLL;

public class TreeToDoublyLinkedList {
	// Initialize previously visited node as NULL. This is
	// static so that the same value is accessible in all recursive calls
	static TreeNode prev = null;
	public static void main(String args[]) {
		TreeNode root = TreeUtils.buildSampleTree();
		
		TreeNode head = null; 
		BinaryTree2DoubleLinkedList(root, head);
	
		TreeNode curr = head;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.right;
		}
		
	}
	
	public static void BinaryTree2DoubleLinkedList(TreeNode root, TreeNode head) {
		if (root == null)
			return;
		
		BinaryTree2DoubleLinkedList(root.left, head);

		// Now convert this node
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right, head);
	}

	/**
	 * This is not incplace.
	 * 
	 * @param root
	 */
	NodeLL first = null;
	NodeLL last = null;

	private void convertToLL(TreeNode root) {
		if (root == null) {
			return;
		}
		NodeLL newNode = new NodeLL(root.data);
		convertToLL(root.left);

		final NodeLL l = last;
		last = newNode;
		if (l == null)
			first = newNode;
		else {
			l.next = newNode;
			last.prev = l;
		}
		convertToLL(root.right);
	}
}
