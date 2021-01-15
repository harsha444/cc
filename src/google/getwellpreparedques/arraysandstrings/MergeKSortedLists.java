package google.getwellpreparedques.arraysandstrings;

import java.util.*;

class ListNode {
	int data;
	ListNode next;
	ListNode() {

	}
	ListNode(int data) {
		this.data = data;
	}
	ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}

public class MergeKSortedLists {
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.data-b.data);
		for (ListNode list : lists) {
			if (list != null) {
				pq.add(list);
			}
		}
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while(!pq.isEmpty()) {
			temp.next = pq.poll();
			temp = temp.next;
			ListNode next = temp.next;
			if(next!=null) {
				pq.add(next);
			}
		}
		return head.next;
	}

	public static void printList(ListNode head){
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		int k = 3;
        int n = 4;
        ListNode arr[] = new ListNode[k];
 
        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);
 
        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);
 
        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);
 
        // Merge all lists
        ListNode head = mergeKLists(arr);
        printList(head);
	}
}