package com.prac.dsalgo.linkedlist;

public class ReverseLinkedList {
	
	Node root;
	
	public void reverse() {
		if(root == null || root.next == null) {
			return;
		}
		Node current = root;
		Node previous = null;
		while(current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		root = previous;
	}
	
	public void reverseRecursive(Node node, Node previous) {
		if(node == null) {
			root = previous;
			return;
		}
		if(node != null) {
			Node next = node.next;
			node.next = previous;
			reverseRecursive(next, node);
		}
	}
	
	void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.val + " "); 
            node = node.next; 
        } 
    }

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
        list.root = list.new Node(1); 
        list.root.next = list.new Node(2); 
        list.root.next.next = list.new Node(3); 
        list.root.next.next.next = list.new Node(4); 
        list.root.next.next.next.next = list.new Node(5); 
        list.root.next.next.next.next.next = list.new Node(6); 
        list.root.next.next.next.next.next.next = list.new Node(7); 
        list.root.next.next.next.next.next.next.next = list.new Node(8); 
  
        System.out.println("Original Linked list "); 
        list.printList(list.root); 
        list.reverse(); 
        System.out.println(""); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        list.printList(list.root);
        System.out.println(""); 
        System.out.println(""); 
        System.out.println("Original Linked list ");
        list.reverseRecursive(list.root, null);
        list.printList(list.root);
	}
	
	class Node {
		int val;
		Node next;
		private Node(int val) {
			this.val = val;
		}
	}

}
