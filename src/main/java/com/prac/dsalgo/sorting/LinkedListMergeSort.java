package com.prac.dsalgo.sorting;

public class LinkedListMergeSort {
	
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode middleNext = middle.next;
        
        middle.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(middleNext);
        
        return mergeList(left, right);
    }
    
    ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode merged = null;
        if(l1.val <= l2.val) {
            merged = l1;
            merged.next= mergeList(l1.next, l2);
        } else {
            merged = l2;
            merged.next = mergeList(l1, l2.next);
        }
        return merged;
    }
    
    ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while(fastPointer != null) {
            fastPointer = fastPointer.next;
            if(fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

	public static void main(String[] args) {
		LinkedListMergeSort lms = new LinkedListMergeSort();
		ListNode head = lms.new ListNode(4);
		head.next = lms.new ListNode(2);
		head.next.next = lms.new ListNode(1);
		head.next.next.next = lms.new ListNode(3);
		
		head = lms.sortList(head);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

}
