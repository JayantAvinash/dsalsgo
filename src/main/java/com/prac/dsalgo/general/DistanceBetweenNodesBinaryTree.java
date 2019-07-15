package com.prac.dsalgo.general;


public class DistanceBetweenNodesBinaryTree {

	public static void main(String[] args) {
		DistanceBetweenNodesBinaryTree d = new DistanceBetweenNodesBinaryTree();
		 Node root = d.new Node(1); 
	        root.left = d.new Node(2); 
	        root.right = d.new Node(3); 
	        root.left.left = d.new Node(4); 
	        root.left.right = d.new Node(5); 
	        root.right.left = d.new Node(6); 
	        root.right.right = d.new Node(7); 
	        root.right.left.right = d.new Node(8); 
	        System.out.println("Dist(4, 5) = " 
	                             + d.findDistance(root, 4, 5)); 
	                               
	        System.out.println("Dist(4, 6) = " 
	                             + d.findDistance(root, 4, 6)); 
	                               
	        System.out.println("Dist(3, 4) = " 
	                             + d.findDistance(root, 3, 4)); 
	                               
	        System.out.println("Dist(2, 4) = " 
	                             + d.findDistance(root, 2, 4)); 
	                               
	        System.out.println("Dist(8, 5) = "
	                             + d.findDistance(root, 8, 5)); 

	}
	
	public Node LCA(Node root, int n1, int n2) {
		if(root == null) {
			return root;
		}
		if(root.val == n1 || root.val == n2) {
			return root;
		}
		Node left = LCA(root.left, n1, n2);
		Node right = LCA(root.right, n1, n2);
		if(left != null && right != null) {
			return root;
		}
		if(left != null) {
			return left;
		}
		if(right != null) {
			return right;
		}
		return null;
	}
	
	public int findLevel(Node root, int n1, int level) {
		if(root == null) {
			return -1;
		}
		if(root.val == n1) {
			return level;
		}
		int left = findLevel(root.left, n1, level + 1);
		return left > -1 ? left : findLevel(root.right, n1, level + 1); 
	}
	
	public int findDistance(Node root, int n1, int n2) {
		Node lca = LCA(root, n1, n2);
		if(lca == null) {
			return Integer.MAX_VALUE;
		}
		int n1Level = findLevel(lca, n1, 0);
		int n2Level = findLevel(lca, n2, 0);
		return n1Level == -1 || n2Level == -1 ? Integer.MAX_VALUE : n1Level + n2Level;
	}
	
	public class Node {
		int val;
		Node left;
		Node right;

		Node(int x) {
			val = x;
		}
	}

}
