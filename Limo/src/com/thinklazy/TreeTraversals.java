package com.thinklazy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {

	public static void main(String[] args) {
		TreeNode tree = TreeUtils.buildSampleTree();
		TreeUtils.printLevelOrder(tree);
/*
		System.out.println("\nPreorder print of tree:");
		preorderPrint(tree);

		System.out.println("\n\nIndented preorder print of tree:");
		preorderPrint(tree, "");

		System.out.println("\nPostorder print of tree:");
		postorderPrint(tree);

		System.out.println("\n\nIndented postorder print of tree:");
		postorderPrint(tree, "");

		System.out.println("\n\nDepth-first search:");
		dfs(tree);
*/
		System.out.println("\nBreadth-first search:");
		bfs(tree);
/*
		System.out.println("\nRecursive depth-first search:");
		recursiveDfsSearch(tree);
*/
	}

	/**
	 * Traverses the given tree in preorder, printing node values on a single
	 * line.
	 */
	static void preorderPrint(TreeNode node) {
		if (node == null)
			return;

		System.out.print(" " + node.data);
		Iterator iter = node.getChildren().iterator();
		while (iter.hasNext()) {
			preorderPrint((TreeNode) iter.next());
		}
	}

	/**
	 * Traverses the given tree in preorder, printing node values indented and
	 * on multiple lines.
	 */
	static void preorderPrint(TreeNode node, String indent) {
		if (node == null)
			return;

		System.out.println(" " + indent + node.data);
		Iterator iter = node.getChildren().iterator();
		while (iter.hasNext()) {
			preorderPrint((TreeNode) iter.next(), indent + "|  ");
		}
	}

	/**
	 * Traverses the given tree in postorder, printing node values on a single
	 * line.
	 */
	static void postorderPrint(TreeNode node) {
		if (node == null)
			return;

		Iterator iter = node.getChildren().iterator();
		while (iter.hasNext()) {
			postorderPrint((TreeNode) iter.next());
		}
		System.out.print(" " + node.data);
	}

	/**
	 * Traverses the given tree in postorder, printing node values indented and
	 * on multiple lines. I did this out of curiosity, and find the resultant
	 * output very difficult to read.
	 */
	static void postorderPrint(TreeNode node, String indent) {
		if (node == null)
			return;

		Iterator iter = node.getChildren().iterator();
		while (iter.hasNext()) {
			postorderPrint((TreeNode) iter.next(), indent + "|  ");
		}
		System.out.println(" " + indent + node.data);
	}

	/**
	 * Performs a depth-first search, starting from the given node, for any node
	 * that satisfies the condition isGoal(node).
	 * 
	 * @param root
	 *            The root of the tree or subtree to be searched.
	 * @return True if a goal node could be found.
	 */
	static boolean dfs(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = (TreeNode) stack.pop();
			if(node == null) 
				continue;
			
			System.out.println("Checking node " + node.data);
			if (isGoal(node)) {
				System.out.println("\nFound goal node " + node.data);
				return true;
			}
			stack.addAll(node.getChildren());
			// dump(stack);
		}
		return false;
	}

	static void recursiveDfsSearch(TreeNode node) {
		if (node == null)
			return;

		System.out.println("Visiting node :" + node.data);
		if (isGoal(node)) {
			System.out.println("Found goal node: " + node.data);
			return;
		}

		for (TreeNode child : node.getChildren()) {
			recursiveDfsSearch(child);
		}
	}
	
	/**
	 * Performs a breadth-first search, starting from the given node, for any
	 * node that satisfies the condition isGoal(node).
	 * 
	 * @param root
	 *            The root of the tree or subtree to be searched.
	 * @return True if a goal node could be found.
	 */
	static boolean bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = (TreeNode) queue.remove();
			if(node == null) 
				continue;
			System.out.println("Checking node " + node.data);
			if (isGoal(node)) {
				System.out.println("\nFound goal node " + node.data);
				return true;
			}
			queue.addAll(node.getChildren());
			// dump(queue);
		}
		return false;
	}
	
	public static void levelOrderOptimal(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		levelOrderOptimalUtil(nodes);
	}
	
	private static void levelOrderOptimalUtil(List<TreeNode> nodes) {
	    List<TreeNode> next = new ArrayList<TreeNode>();
	    for (TreeNode t : nodes) {
	        if (t != null) {
	            System.out.print(t.data);
	            next.add(t.left);
	            next.add(t.right);
	        }
	    }
	    System.out.println();
	    if(next.size() > 0)levelOrderOptimalUtil(next);
	}

	/**
	 * Defines a couple of nodes in the tree to be goal nodes. There is no
	 * "deeper meaning" to these nodes; it's just a hack to test out the search
	 * methods.
	 */
	static boolean isGoal(TreeNode node) {
		return false; //Should be overridden
	}

	/** Prints the contents of the stack (top to the left). */
	static void dump(Stack stack) {
		String temp = "  stack = ";
		for (int i = stack.size() - 1; i >= 0; i--) {
			temp = temp + ((TreeNode) (stack.elementAt(i))).data + " ";
		}
		System.out.println(temp);
	}

	/** Prints the contents of the queue (front to the left). */
	static void dump(Queue queue) {
		String temp = "  queue = ";
		System.out.print(temp);
		while (queue.isEmpty()) {
			System.out.println(((TreeNode) queue.remove()).data + " ");
		}
	}
}