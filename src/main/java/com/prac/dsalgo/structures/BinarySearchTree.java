package com.prac.dsalgo.structures;


public class BinarySearchTree {
	
	Node root;
	
	public boolean insert(int a) {
		Node temp = new Node(a, null, null);
		if(root == null) {
			root = temp;
			return true;
		} else {
			return insert(root, temp);
		}
	}
	
	private boolean insert(Node current, Node inserted) {
		if(inserted.val < current.val) {
			if(current.lTree == null) {
				current.lTree = inserted;
				return true;
			}
			return insert(current.lTree, inserted);
		} else {
			if(current.rTree == null) {
				current.rTree = inserted;
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
		recursiveInorder(current.lTree);
		recursiveInorder(current.rTree);
	}
	
	public void recursivePostorder() {
		if(root == null) {
			return;
		}
		recursiveInorder(root);
	}
	
	private void recursivePoorder(Node current) {
		if(current == null) {
			return;
		}
		recursiveInorder(current.lTree);
		recursiveInorder(current.rTree);
		System.out.print(current.val + " ");
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
