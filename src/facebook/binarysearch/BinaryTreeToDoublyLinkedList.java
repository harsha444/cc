package facebook.binarysearch;

class Node {
    int val;

    Node left;

    Node right;

    public Node() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    private Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeToDoublyLinkedList {
    private Node start = null;

    private Node end = null;

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            if (end != null) {
                end.left = node;
                node.right = end;
            } else {
                start = node;
            }
            end = start;
            inOrder(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return start;
    }

    public static void main(String[] args) {

    }
}
