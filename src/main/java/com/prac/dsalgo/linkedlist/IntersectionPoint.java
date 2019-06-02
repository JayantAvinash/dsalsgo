package com.prac.dsalgo.linkedlist;

public class IntersectionPoint {
	
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        int diff = size1 - size2;
        if(diff > 0) {
            while(diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            diff = -diff;
            while(diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }
        while(head1 != head2 && head1 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 != null ? head1.data : -1;
    }

    static private int getSize(SinglyLinkedListNode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

	public static void main(String[] args) {
		  
        // creating first linked list 
		SinglyLinkedListNode list = new SinglyLinkedListNode(3); 
        list.next = new SinglyLinkedListNode(6); 
        list.next.next = new SinglyLinkedListNode(15);
        SinglyLinkedListNode iNode = list.next.next;
        list.next.next.next = new SinglyLinkedListNode(15); 
        list.next.next.next.next = new SinglyLinkedListNode(30); 
  
        // creating second linked list 
        SinglyLinkedListNode list2 = new SinglyLinkedListNode(10); 
        list2.next = iNode; 
  
        System.out.println("The node of intersection is " + findMergeNode(list, list2)); 

	}

	static class SinglyLinkedListNode {
		int data;
		SinglyLinkedListNode next;
		public SinglyLinkedListNode(int data) {
			this.data = data;
		}
	}

}
