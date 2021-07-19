package linkedlist;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare!=null && hare.next!=null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise.next;
    }

    public static void main(String[] args) {

    }
}
