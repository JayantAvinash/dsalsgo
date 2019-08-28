package com.prac.dsalgo.linkedlist;

// https://leetcode.com/problems/add-two-numbers-ii/
public class SumOfTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		l1 = reverse(l1);
		l2 = reverse(l2);
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
		return reverse(l1);
	}

	public ListNode reverse(ListNode l) {
		ListNode temp = l;
		ListNode prev = null;
		while (temp != null) {
			ListNode next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		SumOfTwoNumbers s = new SumOfTwoNumbers();
		ListNode l1 = s.new ListNode(7);
		l1.next = s.new ListNode(2);
		l1.next.next = s.new ListNode(4);
		l1.next.next.next = s.new ListNode(3);

		ListNode l2 = s.new ListNode(5);
		l2.next = s.new ListNode(6);
		l2.next.next = s.new ListNode(4);

		ListNode sum = s.addTwoNumbers(l1, l2);
		while (sum != null) {
			System.out.print(sum.val + " ");
			sum = sum.next;
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
