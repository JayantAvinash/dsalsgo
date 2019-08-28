package com.prac.dsalgo.trees;

public class TreeFromPostAndInorder {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
			return null;
		}
		return buildTree(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] inorder, int[] postorder, int from, int to, int fromInorder, int toInorder) {
		TreeNode root = new TreeNode(postorder[to]);
		int inorderRootIndex = -1;
		for (int i = fromInorder; i <= toInorder; i++) {
			if (inorder[i] == postorder[to]) {
				inorderRootIndex = i;
				break;
			}
		}
		int postorderTo = to;
		if (inorderRootIndex != fromInorder) {
			if (inorderRootIndex < toInorder) {
				for (int i = from; i <= to; i++) {
					if (postorder[i] == inorder[inorderRootIndex + 1]) {
						postorderTo = i;
						break;
					}
				}
			}

			root.left = buildTree(inorder, postorder, from, postorderTo - 1, fromInorder, inorderRootIndex - 1);
		}
		if (inorderRootIndex != toInorder) {
			if (postorderTo == to) {
				postorderTo = from;
			}
			root.right = buildTree(inorder, postorder, postorderTo, to - 1, inorderRootIndex + 1, toInorder);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeFromPostAndInorder t = new TreeFromPostAndInorder();
		int[] inorder = { 1, 2, 3, 4 };
		int[] postorder = { 1, 4, 3, 2 };
		t.buildTree(inorder, postorder);
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
