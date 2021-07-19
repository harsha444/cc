package linkedlist;

public class CopyListWithRandomPointer {
    class Node {
        int val;

        Node next;

        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node c = head;
        while (c != null) {
            Node temp = c.next;
            c.next = new Node(c.val);
            c.next.next = temp;
            c = temp;
        }

        c = head;
        while (c != null) {
            if (c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }
        c = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (copy.next != null) {
            c.next = c.next.next;
            c = c.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        c.next = c.next.next;
        return copyHead;
    }
}
