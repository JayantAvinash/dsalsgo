package com.prac.dsalgo.linkedlist;

public class LinkedListSumReverseOrder {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		int carryForward = 0;
		ListNode temp = l1;
		ListNode temp1 = null;
		while (temp != null && l2 != null) {
			int i = temp.val + l2.val + carryForward;
			temp.val = i % 10;
			carryForward = i / 10;
			temp1 = temp;
			temp = temp.next;
			l2 = l2.next;
		}
		while (temp != null) {
			int i = temp.val + carryForward;
			temp.val = i % 10;
			carryForward = i / 10;
			temp1 = temp;
			temp = temp.next;
		}
		while (l2 != null) {
			int i = l2.val + carryForward;
			temp1.next = new ListNode(i % 10);
			carryForward = i / 10;
			l2 = l2.next;
			temp1 = temp1.next;
		}
		if (carryForward > 0) {
			temp1.next = new ListNode(carryForward);
			temp1 = temp1.next;
		}
		return l1;
	}

	public static void main(String[] args) {
		LinkedListSumReverseOrder l = new LinkedListSumReverseOrder();
		ListNode l1 = l.new ListNode(9);
		l1.next = l.new ListNode(4);
		l1.next.next = l.new ListNode(5);

		ListNode l2 = l.new ListNode(9);
		l2.next = l.new ListNode(5);
		l2.next.next = l.new ListNode(9);
		l2.next.next.next = l.new ListNode(9);

		l1 = l.addTwoNumbers(l1, l2);
		while (l1 != null) {
			System.out.print(l1.val + " ");
			l1 = l1.next;
		}

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
