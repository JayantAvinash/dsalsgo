package com.prac.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.poll();
			if (t == null || (t.left == null && t.right == null)) {
				continue;
			}
			TreeNode temp = t.left;
			t.left = t.right;
			t.right = temp;
			queue.offer(t.left);
			queue.offer(t.right);
		}
		return root;
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
