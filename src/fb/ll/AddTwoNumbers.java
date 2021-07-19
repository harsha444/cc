package fb.ll;

public class AddTwoNumbers {
    private static int getLen(ListNode l) {
        ListNode temp = l;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;
            int data = l1Val + l2Val + carry;
            int quotient = data % 10;
            carry = data / 10;
            dummyNode.next = new ListNode(quotient);
            dummyNode = dummyNode.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (carry == 1) {
            dummyNode.next = new ListNode(1);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode resp = addTwoNumbers(head1, head2);
        System.out.println(resp);
    }

}
