package google.contests;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

public class SwappingNodesLinkedList {
	public static int getLength(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while(temp!=null) {
			len += 1;
			temp = temp.next;
		}
		return len;
	}

	public static ListNode swapNodes(ListNode head, int k) {
        int listSize = getLength(head);
        int lenFromEnd = listSize - k;
        ListNode temp = new ListNode(0, head);
        ListNode ptr1 = temp;
        ListNode ptr2 = temp;
        k-=1;
        while(k>0) {
        	ptr1 = ptr1.next;
        	k -= 1;
        }

        while(lenFromEnd>0) {
        	ptr2 = ptr2.next;
        	lenFromEnd -= 1;
        }
        int tempData = ptr1.next.val;
        ptr1.next.val = ptr2.next.val;
        ptr2.next.val = tempData;
        return head;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		swapNodes(head, 3);
	}
}