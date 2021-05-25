package topquestions.easy.linkedlist;


import java.util.*;

public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		ListNode temp = head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode nextNode = head;
		while(nextNode != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
        head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
        reverseList(head);
	}
}