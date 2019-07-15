package com.prac.dsalgo.general;

import java.util.ArrayList;
import java.util.List;

public class PairSumInABst {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new ArrayList();
		inorder(root, list);
		int l = 0, r = list.size() - 1;
		while (l < r) {
			int sum = list.get(l) + list.get(r);
			if (sum == k)
				return true;
			if (sum < k)
				l++;
			else
				r--;
		}
		return false;
	}

	public void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
	
	public static void main(String[] args) {
		
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
