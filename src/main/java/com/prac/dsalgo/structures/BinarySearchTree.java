package com.prac.dsalgo.structures;

import java.util.Stack;

public class BinarySearchTree {
	
	Node root;
	int size;
	
	public boolean insert(int a) {
		Node temp = new Node(a, null, null);
		if(root == null) {
			root = temp;
			size++;
			return true;
		} else {
			return insert(root, temp);
		}
	}
	
	private boolean insert(Node current, Node inserted) {
		if(inserted.val < current.val) {
			if(current.lTree == null) {
				current.lTree = inserted;
				size++;
				return true;
			}
			return insert(current.lTree, inserted);
		} else {
			if(current.rTree == null) {
				current.rTree = inserted;
				size++;
				return true;
			}
			return insert(current.rTree, inserted);
		}
	}
	
	public void recursiveInorder() {
		if(root == null) {
			return;
		}
		recursiveInorder(root);
	}
	
	private void recursiveInorder(Node current) {
		if(current == null) {
			return;
		}
		recursiveInorder(current.lTree);
		System.out.print(current.val + " ");
		recursiveInorder(current.rTree);
	}
	
	public void iterativeInorder() {
		if(root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		s.push(temp);
		while(temp.lTree != null) {
			temp = temp.lTree;
			s.push(temp);
		}
		while(!s.isEmpty()) {
			Node n = s.pop();
			System.out.print(n.val + " ");
			if(n.rTree != null) {
				Node right = n.rTree;
				s.push(right);
				while(right.lTree != null) {
					right = right.lTree;
					s.push(right);
				}
			}
		}
	}
	
	public void morrisInorder() {
		if(root == null) {
			return;
		}
		Node prev, current;
		current = root;
		while(current != null) {
			if(current.lTree == null) {
				System.out.print(current.val + " ");
				current = current.rTree;
			} else {
				prev =  current.lTree;
				while(prev.rTree != null && prev.rTree != current) {
					prev = prev.rTree;
				}
				if(prev.rTree == null) {
					prev.rTree = current;
					current = current.lTree;
				} else {
					prev.rTree = null;
					System.out.print(current.val + " ");
					current = current.rTree;
				}
			}
		}
	}
	
	public void recursivePreorder() {
		if(root == null) {
			return;
		}
		recursivePreorder(root);
	}
	
	private void recursivePreorder(Node current) {
		if(current == null) {
			return;
		}
		System.out.print(current.val + " ");
		recursivePreorder(current.lTree);
		recursivePreorder(current.rTree);
	}
	
	public void iterativePreorder() {
		if(root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		s.push(temp);
		while(!s.isEmpty()) {
			Node n = s.pop();
			System.out.print(n.val + " ");
			if(n.rTree != null) {
				s.push(n.rTree);
				
			}
			if(n.lTree != null) {
				s.push(n.lTree);
			}
		}
	}
	
	public void recursivePostorder() {
		if(root == null) {
			return;
		}
		recursivePostorder(root);
	}
	
	private void recursivePostorder(Node current) {
		if(current == null) {
			return;
		}
		recursivePostorder(current.lTree);
		recursivePostorder(current.rTree);
		System.out.print(current.val + " ");
	}
	
	public void iterativePostOrder() {
		if(root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		Node current = root;
		Node prev = null;
		s.push(current);
		while(!s.isEmpty()) {
			current = s.peek();
			if(prev == null || current.equals(prev.lTree) || current.equals(prev.rTree)) {
				if(current.lTree != null) {
					s.push(current.lTree);
				} else if(current.rTree != null) {
					s.push(current.rTree);
				} else {
					Node n = s.pop();
					System.out.print(n.val + " ");
				}
			} else if(prev.equals(current.lTree)) {
				if(current.rTree != null) {
					s.push(current.rTree);
				} else {
					Node n = s.pop();
					System.out.print(n.val + " ");
				}
			} else if(prev.equals(current.rTree)) {
				Node n = s.pop();
				System.out.print(n.val + " ");
			}
			prev = current;
		}
	}
	
	public void twoStackPostorder() {
		if(root == null) {
			return;
		}
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty()) {
			Node n = s1.pop();
			s2.push(n);
			if(n.lTree != null) {
				s1.push(n.lTree);
			}
			if(n.rTree != null) {
				s1.push(n.rTree);
			}
		}
		while(!s2.isEmpty()) {
			Node n = s2.pop();
			System.out.print(n.val + " ");
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.getSize());
		bst.insert(5);
		bst.insert(7);
		bst.insert(3);
		System.out.println(bst.getSize());
		bst.insert(6);
		bst.insert(4);
		bst.insert(2);
		bst.insert(8);
		bst.insert(1);
		System.out.println(bst.getSize());
		bst.recursiveInorder();
		System.out.println();
		bst.recursivePreorder();
		System.out.println();
		bst.recursivePostorder();
		System.out.println();
		bst.iterativeInorder();
		System.out.println();
		bst.iterativePreorder();
		System.out.println();
		bst.iterativePostOrder();
		System.out.println();
		bst.morrisInorder();
		System.out.println();
		bst.twoStackPostorder();
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
