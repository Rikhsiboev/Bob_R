package LinkList;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addAfter(int afterValue, int value) {
        Node current = head;
        do {
            if (current.value == afterValue) {
                Node newNode = new Node(value);
                newNode.next = current.next;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
                size++;
                return;
            }
            current = current.next;
        } while (current != head);
        throw new IllegalArgumentException("Value not found in list");
    }

    public void delete(int value) {
        if (head == null) {
            throw new IllegalStateException("Cannot delete from an empty list");
        }
        if (head.value == value) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
            return;
        }
        Node current = head;
        while (current.next != null && current.next != head) {
            if (current.next.value == value) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.next;
        }
        throw new IllegalArgumentException("Value not found in list");
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.value + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    public int size() {
        return size;
    }
}
