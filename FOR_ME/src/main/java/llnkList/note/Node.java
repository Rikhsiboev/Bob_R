package LinkList.note;

public class Node {
    public int value;  // which value
    public Node next;  // which one love

    private Node head;
    private Node tail;
    private int size;

    public Node() {
        this.size = 0;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void addTail(int value) {  // O(N)
        Node newNode = new Node(value);
        // If the list is empty, set the new node as both the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, add the new node to the end of the list
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public void addToHead(int value) {  // O(n)
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if (tail== null){
            tail=head;
        }

        size++;
    }


    public void addAfter(int node, int value){  // O(n)
        Node current = head;
        while (current!=null){
            if (current.value==node){
                Node newNode = new Node(value);
                newNode.next=current.next;
                current.next= newNode;
                size++;
                return;
            }
            current=current.next;
        }
        throw new IllegalArgumentException("Node not found in list");
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("End");
    }


    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete head from an empty list");
        }
        if (head == tail) {
            // If there is only one node in the list, set both head and tail to null
            head = null;
            tail = null;
        } else {
            // Otherwise, move the head reference to the next node and remove the old head
            head = head.next;
        }
        size--;
    }

    public void deleteTail() {
        if (tail == null) {
            throw new IllegalStateException("Cannot delete tail from an empty list");
        }
        if (head == tail) {
            // If there is only one node in the list, set both head and tail to null
            head = null;
            tail = null;
        } else {
            // Otherwise, iterate through the list to find the node before the tail and set it as the new tail
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void deleteNode(int value) {
        if (head == null) {
            throw new IllegalStateException("Cannot delete node from an empty list");
        }
        if (head.value == value) {
            // If the value to delete is in the head node, remove the head
            deleteHead();
            return;
        }
        if (tail.value == value) {
            // If the value to delete is in the tail node, remove the tail
            deleteTail();
            return;
        }
        // Otherwise, iterate through the list to find the node before the one to delete
        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }
        if (current.next == null) {
            throw new IllegalArgumentException("Value not found in list");
        }
        current.next = current.next.next;
        size--;
    }

}
