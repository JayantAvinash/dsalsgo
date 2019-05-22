package com.prac.dsalgo.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseDoublyLinkedList {
	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
		while (node != null) {
			System.out.print(node.data);
			node = node.next;

			if (node != null) {
				System.out.print(sep);
			}
		}
	}

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		DoublyLinkedListNode temp = head;
		DoublyLinkedListNode dln = null;
		while (temp != null) {
			dln = temp.prev;
			temp.prev = temp.next;
			temp.next = dln;
			temp = temp.prev;
		}
		return dln.prev;
	}

	private static final Scanner scanner = new Scanner(System.in);

	/*
	 * 1 2 3 4
	 */
	public static void main(String[] args) throws IOException {
		DoublyLinkedList llist = new DoublyLinkedList();
		for (int i = 0; i < 4; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist.insertNode(llistItem);
		}
		DoublyLinkedListNode llist1 = reverse(llist.head);

		printDoublyLinkedList(llist1, " ");
		scanner.close();
	}
}
