package topquestions.easy.linkedlist;


import java.util.*;

public class MergeSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		}

		if(l2==null) {
			return l1;
		}

        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while(l1!= null && l2!=null) {
        	if(l1.val < l2.val) {
        		temp.next = l1;
        		l1 = l1.next;
        	} else {
        		temp.next = l2;
        		l2 = l2.next;
        	}
        	temp = temp.next;
        }
        if(l1==null) {
    		temp.next = l2;
    	} else {
    		temp.next = l1;
    	}
    	return res.next;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
        head.next.next = new ListNode(4);

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);
        mergeTwoLists(head, head1);
	}
}
