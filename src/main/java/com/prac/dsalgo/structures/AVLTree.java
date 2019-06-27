package com.prac.dsalgo.structures;

public class AVLTree {
	
	Node root;
	
	private Node insert(Node temp, int val) {
		if(temp == null) {
			temp = new Node(val);
			return temp;
		}
		if(val < temp.val) {
			temp.left = insert(temp.left, val);
		} else if(val > temp.val) {
			temp.right = insert(temp.right, val);
		}
		temp.height = 1 + Math.max(height(temp.left), height(temp.right));
		
		int balance = getBalance(temp);
		
		// left left case
		if(balance > 1 && val < temp.left.val) {
			temp = rightRotate(temp);
		}
		
		// right right case
		if(balance < -1 && val > temp.right.val) {
			temp = leftRotate(temp);
		}
		
		// left right case
		if(balance > 1 && val > temp.left.val) {
			temp.left = leftRotate(temp.left);
			temp = rightRotate(temp);
		}
		
		// right left case
		if(balance < -1 && val < temp.right.val) {
			temp.right = rightRotate(temp.right);
			temp = leftRotate(temp);
		}
		
		return temp;
	}
	
	private int getBalance(Node n) {
		if(n == null) {
			return 0;
		}
		return height(n.left) - height(n.right);
	}
	
	public int height(Node n) {
		if(n == null) {
			return 0;
		}
		return n.height;
	}
	
	private Node leftRotate(Node y) {
		Node right = y.right;
		Node temp = right.left;
		right.left = y;
		y.right = temp;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		right.height = Math.max(height(right.left), height(right.right)) + 1;
		return right;
	}
	
	private Node rightRotate(Node y) {
		Node left = y.left;
		Node temp = left.right;
		
		left.right = y;
		y.left = temp;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		left.height = Math.max(height(left.left), height(left.right)) + 1;
		return left;
	}
	
	public void preorder(Node temp) {
		if(temp == null) {
			return;
		}
		if(temp.left != null) {
			preorder(temp.left);
		}
		System.out.print(temp.val + " ");
		if(temp.right != null) {
			preorder(temp.right);
		}
	}

	public static void main(String[] args) {
		  AVLTree tree = new AVLTree(); 
		  
	        /* Constructing tree given in the above figure */
	        tree.root = tree.insert(tree.root, 10); 
	        tree.root = tree.insert(tree.root, 5);
	        tree.preorder(tree.root);
	        System.out.println();
	        tree.root = tree.insert(tree.root, 30); 
	        tree.root = tree.insert(tree.root, 40);
	        tree.preorder(tree.root);
	        System.out.println();
	        tree.root = tree.insert(tree.root, 50);
	        tree.preorder(tree.root);
	        System.out.println();
	        tree.root = tree.insert(tree.root, 25);
	        
	        tree.preorder(tree.root);

	}
	
	class Node {
		int val, height;
		Node left, right;
		Node(int val) {
			this.val = val;
			this.height = 1;
		}
	}

}
