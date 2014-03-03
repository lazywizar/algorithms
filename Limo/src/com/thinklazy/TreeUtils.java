package com.thinklazy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {
    public static void main(String args[]) throws Exception {
        TreeNode root = buildSampleTree();
        levelOrderOptimal(root);
        System.out.println();
        // printPathBetweenTwoNodeData(root,4, 6);

        /*
         * List<TreeNode> path = printPathBetweenTwoNodeData(root,4, 6); for(TreeNode n : path) {
         * System.out.print(n.data + " ===> "); } mirror(root); System.out.println();
         * printInOrder(root); System.out.println(); System.out.println(isMirror(root,
         * buildSampleTree()));
         */
    }

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.data == root2.data && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }

    public static void printPathThatSumToK(TreeNode root, int k, List<TreeNode> pathTillNow) {
        if (root == null) {
            return;
        }
        k = k - root.data;
        pathTillNow.add(root);
        if (k == 0) {
            for (TreeNode n : pathTillNow) {
                System.out.print(n.data + " ");
            }
            System.out.println();
            // return;
        }
        printPathThatSumToK(root.left, k, pathTillNow);
        printPathThatSumToK(root.right, k, pathTillNow);
        pathTillNow.remove(root); // very important :P
    }

    public static TreeNode mirror(TreeNode node) {
        if (node != null) {
            TreeNode temp;

            /* do the subtrees */
            mirror(node.left);
            mirror(node.right);

            /* Swap left and right subtree */
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }

    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data);
        printInOrder(node.right);
    }

    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static TreeNode LCAData(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }
        TreeNode left = LCAData(root.left, a, b);
        TreeNode right = LCAData(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static void printPathBetweenTwoNodeData(TreeNode root, int a, int b) throws Exception {
        TreeNode lca = LCAData(root, a, b);
        List<TreeNode> pathA = getPathToNodeData(lca, a);
        List<TreeNode> pathB = getPathToNodeData(lca, b);

        Collections.reverse(pathA);
        for (TreeNode n : pathA) {
            System.out.print(n.data + " => ");
        }
        pathB.remove(lca); // remove the root to be printed twice.
        for (TreeNode n : pathB) {
            System.out.print(n.data + " => ");
        }

    }

    public static List<TreeNode> getPathToNodeData(TreeNode root, int nodeData) throws Exception {
        return getPathToNodeDataUtil(root, nodeData);
    }

    public static void printPathToNodeDataUtil(TreeNode root, int nodeData,
            List<TreeNode> pathTillNow) {
        if (root == null) {
            return;
        }
        pathTillNow.add(root);
        if (nodeData == root.data) {
            for (TreeNode n : pathTillNow) {
                System.out.print(n.data);
            }
            System.out.println();
            return;
        }
        printPathToNodeDataUtil(root.left, nodeData, pathTillNow);
        printPathToNodeDataUtil(root.right, nodeData, pathTillNow);
        pathTillNow.remove(root); // very important :P
    }

    public static List<TreeNode> getPathToNodeDataUtil(TreeNode root, int nodeData) {
        if (root == null) {
            return null;
        }
        List<TreeNode> path = new ArrayList<TreeNode>();
        path.add(root);
        if (nodeData == root.data) {
            return path;
        }
        List<TreeNode> leftPath = getPathToNodeDataUtil(root.left, nodeData);
        List<TreeNode> rightPath = getPathToNodeDataUtil(root.right, nodeData);
        if (leftPath != null && !leftPath.isEmpty()) {
            path.addAll(leftPath);
        } else if (rightPath != null && !rightPath.isEmpty()) {
            path.addAll(rightPath);
        } else {
            path.remove(root);
        }
        return path;
    }

    public static List<TreeNode> printPathToNodeIterative(TreeNode root, TreeNode a) {
        // TODO
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == a) {
                stack.push(a);
                break;
            }
        }
        return stack.subList(0, stack.size());
    }

    public static void printLevel(TreeNode p, int level) {
        if (p == null)
            return;
        if (level == 1) {
            System.out.print(p.data + " ");
        } else {
            printLevel(p.left, level - 1);
            printLevel(p.right, level - 1);
        }
    }

    public static void printLevelOrder(TreeNode root) {
        int height = maxHeight(root);
        for (int level = 1; level <= height; level++) {
            printLevel(root, level);
            System.out.println();
        }
    }

    public static int maxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    }

    public static void printLevelOrderOptimal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.remove();
            if (node == null)
                continue;
            System.out.println("Checking node " + node.data);
            queue.addAll(node.getChildren());
        }
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
        if (next.size() > 0)
            levelOrderOptimalUtil(next);
    }

    public static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node6.setLeft(node7);
        return root;
    }
}
