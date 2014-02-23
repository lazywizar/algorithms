package com.thinklazy;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {
		super();
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public boolean isLeaf() throws Exception {
		if(this == null) {
			throw new Exception("Node is null, can not decide if its leaf or not");
		}
		if(this.left == null && this.right == null) {
			return true;
		} 
		return false;
	}

}
