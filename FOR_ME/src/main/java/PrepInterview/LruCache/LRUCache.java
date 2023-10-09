package PrepInterview.LruCache;

import java.util.HashMap;

public class LRUCache {

    //1 double LinkedList => Double Linked list Node
    //2 dummy head tail - Size - capacity
    //3 Put(int,int)
    //4 get(int)

    // step 1
    public class DoubleLinkedListNode {
        int key;
        int value;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DoubleLinkedListNode() {
        }
    }

    //step 2
    int size;
    int capacity;
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;
    HashMap<Integer, DoubleLinkedListNode> cashMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DoubleLinkedListNode();
        this.tail = new DoubleLinkedListNode();
        head.next = tail;
        tail.prev = head;

    }


    public void addNode(DoubleLinkedListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode prev = node.prev;
        DoubleLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DoubleLinkedListNode node) {
        removeNode(node);
        addNode(node);
    }

    public DoubleLinkedListNode popTail() {
        DoubleLinkedListNode popped = tail.prev;
        removeNode(popped);
        return popped;
    }

    public int get(int key) {
        DoubleLinkedListNode node = cashMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedListNode node = cashMap.get(key);
        if (node != null) {//item exist
            node.value = value;
            moveToHead(node);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            cashMap.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity){
                DoubleLinkedListNode pop = popTail();
                cashMap.remove(pop);
                size--;
            }
        }
    }




}
