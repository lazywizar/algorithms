package com.thinklazy;

import java.util.ArrayList;
import java.util.List;

public class PrintAllTreePaths {
	public static void main(String args[]) {
		TreeNode root = TreeUtils.buildSampleTree();
		printAllRootToLeafPaths(root);
		
		System.out.println("\n");
		printPathThatSumToK(root, 11, new ArrayList<TreeNode>());
		printPathThatSumToK(root, 4, new ArrayList<TreeNode>());
		printPathThatSumToK(root, 10, new ArrayList<TreeNode>());
	}
	
	public static void printAllRootToLeafPaths(TreeNode root) {
		if(root == null) {
			return;
		}
		try {
			printAllPaths(root, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printAllPaths(TreeNode node, String pathTillNow) throws Exception {
		if(node == null) {
			return;
		}
		if(!pathTillNow.isEmpty()) {
			pathTillNow = pathTillNow + "->";
		}
		
		if(node.isLeaf()) {
			System.out.println(pathTillNow + node.data);
			return;
		}
		
		printAllPaths(node.left, pathTillNow + node.data);
		printAllPaths(node.right, pathTillNow + node.data);
	}
	
	
	public static void printPathThatSumToK(TreeNode root, int k, List<TreeNode> pathTillNow) {
		if(root == null) {
			return;
		}
		k = k - root.data;
		pathTillNow.add(root);
		if(k == 0) {
			for(TreeNode n : pathTillNow) {
				System.out.print(n.data + " ");
			}
			System.out.println();
			//return;
		}
		printPathThatSumToK(root.left,k, pathTillNow);
		printPathThatSumToK(root.right, k, pathTillNow);
		pathTillNow.remove(root); // very important :P
	}
	
}
