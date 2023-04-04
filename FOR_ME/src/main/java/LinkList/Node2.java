package LinkList;



public class Node2 {
    int value;
    Node2 prev;
    Node2 next;

    private Node2 head;
    private Node2 tail;
    private int size;

    public Node2() {
        this.size = 0;
    }

    public Node2(int value) {
        this.value = value;
    }

    public Node2(int value, Node2 prev, Node2 next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public void addTail(int value) {
        Node2 newNode2 = new Node2(value, tail, null);
        if (head == null) {
            head = newNode2;
        } else {
            tail.next = newNode2;
        }
        tail = newNode2;
        size++;
    }

    public void addToHead(int value) {
        Node2 newNode2 = new Node2(value, null, head);
        if (head == null) {
            tail = newNode2;
        } else {
            head.prev = newNode2;
        }
        head = newNode2;
        size++;
    }

    public void addAfter(int Node2, int value) {
        Node2 current = head;
        while (current != null) {
            if (current.value == Node2) {
                Node2 newNode2 = new Node2(value, current, current.next);
                if (current.next != null) {
                    current.next.prev = newNode2;
                } else {
                    tail = newNode2;
                }
                current.next = newNode2;
                size++;
                return;
            }
            current = current.next;
        }
        throw new IllegalArgumentException("Node2 not found in list");
    }

    public void print() {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.next;
        }
        System.out.println("End");
    }
    public void printAllReverse() {
        Node2 current = tail;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete head from an empty list");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteTail() {
        if (tail == null) {
            throw new IllegalStateException("Cannot delete tail from an empty list");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void deleteNode2(int value) {
        if (head == null) {
            throw new IllegalStateException("Cannot delete Node2 from an empty list");
        }
        if (head.value == value) {
            deleteHead();
            return;
        }
        if (tail.value == value) {
            deleteTail();
            return;
        }
        Node2 current = head;
        while (current != null) {
            if (current.value == value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return;
            }
            current = current.next;
        }
        throw new IllegalArgumentException("Value not found in list");
    }
}
