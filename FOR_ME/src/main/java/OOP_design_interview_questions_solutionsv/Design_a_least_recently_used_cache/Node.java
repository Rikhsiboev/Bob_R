package OOP_design_interview_questions_solutionsv.Design_a_least_recently_used_cache;

import java.util.HashMap;

class Node {
    String results;
    Node next;

    public Node(String results) {
        this.results = results;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void moveToFront(Node node) {
        // Implement the logic to move the given node to the front of the linked list
    }

    public void appendToFront(Node node) {
        // Implement the logic to append the given node to the front of the linked list
    }

    public void removeFromTail() {
        // Implement the logic to remove the node from the tail of the linked list
    }
}

class Cache {
    int MAX_SIZE;
    int size;
    HashMap<String, Node> lookup;
    LinkedList linkedList;

    public Cache(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.size = 0;
        this.lookup = new HashMap<>();
        this.linkedList = new LinkedList();
    }

    public String get(String query) {
        Node node = this.lookup.get(query);
        if (node == null) {
            return null;
        }
        this.linkedList.moveToFront(node);
        return node.results;
    }

    public void set(String results, String query) {
        Node node = this.lookup.get(query);
        if (node != null) {
            node.results = results;
            this.linkedList.moveToFront(node);
        } else {
            if (this.size == this.MAX_SIZE) {
               // this.lookup.remove(this.linkedList.tail.query);
                this.linkedList.removeFromTail();
            } else {
                this.size++;
            }
            Node newNode = new Node(results);
            this.linkedList.appendToFront(newNode);
            this.lookup.put(query, newNode);
        }
    }
}
