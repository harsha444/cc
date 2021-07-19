package linkedlist;

public class ReArrangeLinkedList {
    private static ListNode getMiddleNode(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = getMiddleNode(head);
        ListNode first = head;
        ListNode second = reverse(middle);
        reOrderUtil(first, second);
    }

    private static void reOrderUtil(ListNode first, ListNode second) {
        while (first != null && second != null) {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
        if(first!=null) {
            first.next = null;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = head;
        while (curr != null) {
            nextNode = nextNode.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
