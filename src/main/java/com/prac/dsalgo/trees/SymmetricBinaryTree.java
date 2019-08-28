package com.prac.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricBinaryTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root.left);
		nodes.offer(root.right);
		while (!nodes.isEmpty()) {
			TreeNode t1 = nodes.poll();
			TreeNode t2 = nodes.poll();
			if (t1 == null && t2 == null) {
				continue;
			} else if ((t1 == null && t2 != null) || t2 == null && t1 != null) {
				return false;

			} else if (t1.val != t2.val) {
				return false;
			}
			nodes.offer(t1.left);
			nodes.offer(t2.right);
			nodes.offer(t1.right);
			nodes.offer(t2.left);
		}
		return true;
	}

	public static void main(String[] args) {
		SymmetricBinaryTree tree = new SymmetricBinaryTree();
		TreeNode root = tree.new TreeNode(1);
		root.left = tree.new TreeNode(2);
		root.right = tree.new TreeNode(2);
		root.left.left = tree.new TreeNode(3);
		root.left.right = tree.new TreeNode(4);
		root.right.left = tree.new TreeNode(4);
		root.right.right = tree.new TreeNode(3);
		System.out.println(tree.isSymmetric(root));
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
