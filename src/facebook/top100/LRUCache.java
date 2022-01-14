package facebook.top100;

import java.util.HashMap;

class DLinkedNode {
    int key;

    int val;

    DLinkedNode left;

    DLinkedNode right;
}

public class LRUCache {
    int capacity;

    DLinkedNode head;

    DLinkedNode tail;

    HashMap<Integer, DLinkedNode> cache;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkedNode();
        head.left = null;
        this.tail = new DLinkedNode();
        tail.right = null;
        head.right = tail;
        tail.left = head;
        this.cache = new HashMap<>();
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.left;
        DLinkedNode next = node.right;
        prev.right = next;
        next.left = prev;
    }

    private void addNode(DLinkedNode node) {
        node.left = head;
        node.right = head.right;
        head.right.left = node;
        head.right = node;
    }

    private void moveNodeToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        moveNodeToHead(cache.get(key));
        return cache.get(key).val;
    }

    private void set(int key, int val) {

    }
}
