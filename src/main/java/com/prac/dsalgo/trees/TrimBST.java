package com.prac.dsalgo.trees;

// https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimBST {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return root;
		}
		while (root != null && root.val < L) {
			root = root.right;
		}
		if (root == null) {
			return root;
		}
		while (root != null && root.val > R) {
			root = root.left;
		}
		if (root == null) {
			return root;
		}
		if (root.val > R || root.val < L) {
			root = trimBST(root, L, R);
		}
		TreeNode temp = root;
		while (temp.left != null && temp.left.val >= L) {
			temp = temp.left;
		}
		if (temp.left != null) {
			temp.left = trimBST(temp.left, L, R);
		}
		TreeNode temp1 = root;
		while (temp1.right != null && temp1.right.val <= R) {
			temp1 = temp1.right;
		}
		if (temp1.right != null) {
			temp1.right = trimBST(temp1.right, L, R);
		}
		return root;
	}

	public static void main(String[] args) {
		TrimBST t = new TrimBST();
		TreeNode root = t.new TreeNode(4);
		root.left = t.new TreeNode(2);
		root.right = t.new TreeNode(5);
		root.left.left = t.new TreeNode(1);
		root.left.right = t.new TreeNode(3);
		root = t.trimBST(root, 2, 4);
		System.out.println(root.val);

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
