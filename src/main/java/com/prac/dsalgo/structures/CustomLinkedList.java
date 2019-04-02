package com.prac.dsalgo.structures;

public class CustomLinkedList {

	private Node root;
	private int size;

	public boolean add(int a) {
		Node n = new Node(a, null, null);
		if (root == null) {
			root = n;
		} else {
			Node temp = root;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = n;
			n.left = temp;
		}
		size++;
		return true;
	}

	// removes first element of the list
	public int remove() {
		if (root == null) {
			return 0;
		}
		Node temp = root;
		root = root.right;
		if (root != null) {
			temp.right = null;
			root.left = null;
		}
		size--;
		return temp.value;
	}

	public int getSize() {
		return size;
	}
	
	public void push(int a) {
		Node temp = new Node(a, null, root);
		if(root == null) {
			root = temp;
		} else {
			root.left = temp;
		}
		root = temp;
		size++;
	}
	
	public int pop() {
		return remove();
	}
	
	public int removeLast() {
		if(root == null) {
			return 0;
		}
		Node temp = root;
		if(size == 1) {
			root = null;
			size--;
			return root.value;
		}
		
		while(temp.right != null) {
			temp = temp.right;
		}
		Node temp1 = temp.left;
		temp1.right = null;
		temp.left = null;
		size--;
		return temp.value;
	}
	
	public void print() {
		if(root != null) {
			Node temp = root;
			for(int i = 0; i < size; i++) {
				System.out.print(temp.value + "\t");
				temp = temp.right;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		CustomLinkedList cll = new CustomLinkedList();
		cll.add(3);
		cll.add(5);
		cll.push(6);
		cll.print();
		System.out.println(cll.getSize());
		cll.removeLast();
		cll.print();
		System.out.println(cll.getSize());
	}

	class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

}
