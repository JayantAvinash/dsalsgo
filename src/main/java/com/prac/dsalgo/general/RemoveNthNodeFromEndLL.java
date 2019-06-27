package com.prac.dsalgo.general;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndLL {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        if(n <= 0) {
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = head;
        int x = 0;
        while(x < n && temp1 != null) {
            x++;
            temp1 = temp1.next;
        }
        if(x < n) {
            return null;
        }
        if(temp1 == null) {
            ListNode temp = head.next;
            head.next = null;
            head = temp;
            return head;
        }
        while(temp1.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        ListNode temp3 = temp2.next.next;
        temp2.next.next = null;
        temp2.next = temp3;
        return head;
    }
	
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public void print(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndLL r = new RemoveNthNodeFromEndLL();
		ListNode head = r.new ListNode(1);
		head.next = r.new ListNode(2);
		head.next.next = r.new ListNode(3);
		head.next.next.next = r.new ListNode(4);
		head.next.next.next.next = r.new ListNode(5);
		r.print(head);
		head = r.removeNthFromEnd(head, 5);
		System.out.println();
		r.print(head);
	}

}
