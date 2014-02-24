package com.thinklazy;

/*
 TreeList main methods:
 -join() -- utility to connect two list TreeNodes
 -append() -- utility to append two lists
 -treeToList() -- the core recursive function
 */

class TreeList {

	// Demonstrate tree->list with the list 1..5
	public static void main(String[] args) {

		// first build the tree shown in the problem document
		// http://cslibrary.stanford.edu/109/
		TreeNode root = new TreeNode(4);
		treeInsert(root, 2);
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 5);

		System.out.println("tree:");
		printTree(root); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		TreeNode head = treeToList(root);
		printList(head); // 1 2 3 4 5 yay!
	}

	/*
	 * helper function -- given two list TreeNodes, join them together so the
	 * second immediately follow the first. Sets the .next of the first and the
	 * .previous of the second.
	 */
	public static void join(TreeNode a, TreeNode b) {
		a.right = b;
		b.left = a;
	}

	/*
	 * helper function -- given two circular doubly linked lists, append them
	 * and return the new list.
	 */
	public static TreeNode append(TreeNode a, TreeNode b) {
		// if either is null, return the other
		if (a == null)
			return (b);
		if (b == null)
			return (a);

		// find the last TreeNode in each using the .previous pointer
		TreeNode aLast = a.left;
		TreeNode bLast = b.left;

		// A1->A2->A3--------->B1->B2->B3------>back to A1.. so last to first
		join(aLast, b);
		join(bLast, a);

		return (a);
	}

	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a
	 * circular doubly linked list which is returned.
	 */
	public static TreeNode treeToList(TreeNode root) {
		// base case: empty tree -> empty list
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode leftList = treeToList(root.left);
		TreeNode rightList = treeToList(root.right);

		// We can not append node to list.. so convert this to circular LL of
		// size 1.
		root.left = root;
		root.right = root;

		return (append(append(leftList, root), rightList));
	}

	/*
	 * Given a non-empty tree, insert a new TreeNode in the proper place. The
	 * tree must be non-empty because Java's lack of reference variables makes
	 * that case and this method messier than they should be.
	 */
	public static void treeInsert(TreeNode root, int newData) {
		if (newData <= root.data) {
			if (root.left != null)
				treeInsert(root.left, newData);
			else
				root.left = new TreeNode(newData);
		} else {
			if (root.right != null)
				treeInsert(root.right, newData);
			else
				root.right = new TreeNode(newData);
		}
	}

	// Do an inorder traversal to print a tree
	// Does not print the ending "\n"
	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(Integer.toString(root.data) + " ");
		printTree(root.right);
	}

	// Do a traversal of the list and print it out
	public static void printList(TreeNode head) {
		TreeNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.right;
			if (current == head)
				break;
		}

		System.out.println();
	}

}