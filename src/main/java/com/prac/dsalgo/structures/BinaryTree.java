package com.prac.dsalgo.structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	Node root;

	// Adding nodes in binary tree level wise using stack
	public boolean add(int a) {
		Node temp = new Node(a, null, null);
		if (root == null) {
			root = temp;
			return true;
		}
		Stack<Node> s = new Stack<Node>();
		Stack<Node> s1 = new Stack<Node>();
		s.push(root);
		while (!s.isEmpty()) {
			Node n = s.pop();
			if (n.lTree == null) {
				n.lTree = temp;
				return true;
			}
			if (n.rTree == null) {
				n.rTree = temp;
				return true;
			}
			if (s.isEmpty()) {
				s.push(n.rTree);
				s.push(n.lTree);
				while (!s1.isEmpty()) {
					s.push(s1.pop());
				}
			} else {
				s1.push(n.lTree);
				s1.push(n.rTree);
			}
		}
		return true;

	}

	// Adding nodes in binary tree level wise using queue
	public boolean addv2(int a) {
		Node temp = new Node(a, null, null);
		if (root == null) {
			root = temp;
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.lTree != null) {
				queue.add(n.lTree);
			} else {
				n.lTree = temp;
				return true;
			}
			if (n.rTree != null) {
				queue.add(n.rTree);
			} else {
				n.rTree = temp;
				return true;
			}

		}
		return true;
	}

	class NodeRelations {
		Node current;
		Node parent;
		boolean isLeft;

		public NodeRelations(Node current, Node parent, boolean isLeft) {
			super();
			this.current = current;
			this.parent = parent;
			this.isLeft = isLeft;
		}

	}

	public void Preorder(Node root1) {
		if (root1 == null) {
			return;
		}
		System.out.print(root1.val + " ");
		if (root1.lTree != null) {
			Preorder(root1.lTree);
		}
		if (root1.rTree != null) {
			Preorder(root1.rTree);
		}
	}

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.add(1);
		b.Preorder(b.root);
		b.add(2);
		System.out.println();
		b.Preorder(b.root);
		b.add(3);
		System.out.println();
		b.Preorder(b.root);
		b.add(4);
		System.out.println();
		b.Preorder(b.root);
		b.add(5);
		System.out.println();
		b.Preorder(b.root);
		b.add(6);
		System.out.println();
		b.Preorder(b.root);
		b.add(7);
		System.out.println();
		b.Preorder(b.root);
	}

	class Node {
		int val;
		Node lTree;
		Node rTree;

		Node(int val, Node lTree, Node rTree) {
			super();
			this.val = val;
			this.lTree = lTree;
			this.rTree = rTree;
		}

	}
}
