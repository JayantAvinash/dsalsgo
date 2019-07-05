package com.prac.dsalgo.structures;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class LevelConnectedTree {

	public Node connect(Node root) {
		Node temp1 = root;
		while (temp1 != null) {

			Node temp = temp1;
			while (temp != null) {
				if (temp.left != null) {
					if (temp.right != null) {
						temp.left.next = temp.right;
					} else {
						temp.left.next = getNextRight(temp);
					}
				}
				if (temp.right != null) {
					temp.right.next = getNextRight(temp);
				}
				temp = temp.next;
			}
			if (temp1.left != null) {
				temp1 = temp1.left;
			} else if (temp1.right != null) {
				temp1 = temp1.right;
			} else {
				temp1 = getNextRight(temp1);
			}
		}
		return root;
	}

	public Node connectRecursive(Node root) {
		connectRecur(root);
		return root;
	}

	private void connectRecur(Node root) {
		if (root == null) {
			return;
		}
		if (root.next != null) {
			connectRecur(root.next);
		}
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
				root.right.next = getNextRight(root);
			} else {
				root.left.next = getNextRight(root);
			}
			connectRecur(root.left);
		} else if (root.right != null) {
			root.right.next = getNextRight(root);
			connectRecur(root.right);
		} else {
			connectRecur(getNextRight(root));
		}
	}

	private Node getNextRight(Node temp) {
		while (temp.next != null) {
			if (temp.next.left != null) {
				return temp.next.left;
			}
			if (temp.next.right != null) {
				return temp.next.right;
			}
			temp = temp.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

}
