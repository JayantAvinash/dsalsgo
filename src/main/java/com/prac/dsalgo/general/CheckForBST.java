package com.prac.dsalgo.general;

import java.util.Stack;

public class CheckForBST {

	public static void main(String[] args) {
		CheckForBST tree = new CheckForBST();
		TreeNode root = tree.new TreeNode(4);
		root.left = tree.new TreeNode(2);
		root.right = tree.new TreeNode(5);
		root.left.left = tree.new TreeNode(1);
		root.left.right = tree.new TreeNode(3);
		System.out.println(tree.isValidBSTRecursive(root));

	}

	public boolean isValidBSTRecursive(TreeNode root) {
		if (root == null) {
			return true;
		}
		return inorder(root);
	}

	// recursive
	boolean inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		int prev = 0;
		int count = 0;
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			if (count > 0 && prev >= n.val) {
				return false;
			}
			count++;
			prev = n.val;
			if (n.right != null) {
				TreeNode right = n.right;
				stack.push(right);
				TreeNode rightLeft = right.left;
				while (rightLeft != null) {
					stack.push(rightLeft);
					rightLeft = rightLeft.left;
				}
			}
		}
		return true;
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return inorder(root, null, null);
	}

	boolean inorder(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return true;
		}
		if (min != null && root.val <= min.val) {
			return false;
		}
		if (max != null && root.val >= max.val) {
			return false;
		}
		return inorder(root.left, min, root) && inorder(root.right, root, max);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
