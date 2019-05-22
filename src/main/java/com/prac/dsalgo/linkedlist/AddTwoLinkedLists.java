package com.prac.dsalgo.linkedlist;

public class AddTwoLinkedLists {
	
	/* public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    BigInteger n1 = ll.new BigInteger("0"), n2 = ll.new BigInteger("0");
    int count = 0;
    while(l1 != null) {
        BigInteger current = BigInteger.TEN.pow(count++).multiply(BigInteger.valueOf(l1.val));
        n1 = n1.add(current);
        l1 = l1.next;
    }
    count = 0;
    while(l2 != null) {
        BigInteger current = BigInteger.TEN.pow(count++).multiply(BigInteger.valueOf(l2.val));
        n2 = n2.add(current);
        l2 = l2.next;
    }
    n1 = n1.add(n2);
    int r = n1.remainder(BigInteger.TEN).intValue();
    n1 = n1.divide(BigInteger.TEN);
    ListNode sumList = ll.new ListNode(r);
    ListNode temp = sumList;
    while(n1.compareTo(BigInteger.ZERO) > 0) {
        r = n1.remainder(BigInteger.TEN).intValue();
        n1 = n1.divide(BigInteger.TEN);
        ListNode l = ll.new ListNode(r);
        temp.next = l;
        temp = l;
    }
    return sumList;
} */

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
    ListNode temp1 = l1;
    ListNode temp2 = l2;
    ListNode sumNode = new ListNode(0);
    ListNode current= sumNode;
    while(temp1 != null || temp2 != null) {
        if(temp1 != null) {
            current.val += temp1.val;
            temp1 = temp1.next;
        }
        if(temp2 != null) {
            current.val += temp2.val;
            temp2 = temp2.next;
        }
        int carryForward = current.val / 10;
        current.val = current.val % 10;
        if(temp1 != null || temp2 != null || carryForward > 0) {
            current.next = new ListNode(carryForward);
            current = current.next;
        }
    }
    return sumNode;
}

	public static void main(String[] args) {
		AddTwoLinkedLists ll = new AddTwoLinkedLists();
		ListNode l1 = ll.new ListNode(2);
		l1.next = ll.new ListNode(4);
		l1.next.next = ll.new ListNode(3);
		
		ListNode l2 = ll.new ListNode(5);
		l2.next = ll.new ListNode(6);
		l2.next.next = ll.new ListNode(4);
		
		ListNode sum = ll.addTwoNumbers(l1, l2);
		while(sum != null) {
			System.out.print(sum.val + " ");
			sum = sum.next;
		}
	}
	
	public class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		  }

}
