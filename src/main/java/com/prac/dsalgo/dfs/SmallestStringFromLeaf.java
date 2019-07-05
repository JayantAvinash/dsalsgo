package com.prac.dsalgo.dfs;

// https://leetcode.com/problems/smallest-string-starting-from-leaf/
public class SmallestStringFromLeaf {

	public String smallestFromLeaf(TreeNode root) {
		return dfs(root, "");
	}

	public String dfs(TreeNode node, String suffix) {
		if (node == null) {
			return suffix;
		}
		suffix = "" + (char) ('a' + node.val) + suffix;
		if (node.left == null && node.right == null) {
			return suffix;
		}
		if (node.left == null || node.right == null) {
			return (node.left == null) ? dfs(node.right, suffix) : dfs(node.left, suffix);
		}

		String left = dfs(node.left, suffix);
		String right = dfs(node.right, suffix);
		return left.compareTo(right) <= 0 ? left : right;
	}

	public static void main(String[] args) {
		SmallestStringFromLeaf s = new SmallestStringFromLeaf();
		TreeNode t = s.new TreeNode(0);
		t.left = s.new TreeNode(1);
		t.right = s.new TreeNode(2);
		t.left.left = s.new TreeNode(3);
		t.left.right = s.new TreeNode(4);
		t.right.left = s.new TreeNode(3);
		t.right.right = s.new TreeNode(4);
		System.out.println(s.smallestFromLeaf(t));
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
