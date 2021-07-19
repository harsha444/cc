package linkedlist;

public class ReverseLLII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        left -= 1;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        dummy.next = head;
        while (left != 0) {
            head = head.next;
            dummy = dummy.next;
            left -= 1;
            right -= 1;
        }
        ListNode curr = head;
        ListNode newTail = curr;
        ListNode prev = dummy;
        ListNode nextNode = head;
        while (right != 0) {
            nextNode = nextNode.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            right -= 1;
        }
        dummy.next = prev;
        newTail.next = curr;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseBetween(head, 2, 4);
    }
}
