package Review3_LinkedLists;

public class UserLinkedList {
    UserNode head;
    UserNode tail;
    int size;

    public UserLinkedList() {
        this.size=0;
    }
    boolean isEmpty() { return head==null;}
    void insertLast(UserNode node){
        if (isEmpty()) {// 1. List is empty
            head=tail=node;
        } else {  // 2 Not empty
            tail.next=node;
            tail=node;
        }
        size++;
    }
    void printNames(){
        if(isEmpty()) {System.out.println("List is is empty");
            return;
        }
        // Assign Current value to head
        UserNode current=head;
        // loop
        System.out.println();
        while(current!=null){
            System.out.print(current.name+ " => ");
            current=current.next;
            if (current==null)  System.out.print("null");
        }
    }

    void deleteByName(String name) {
        if (isEmpty()) {
            System.out.println("List is is empty");
            return;
        }
        UserNode prev=head;
        UserNode current = head;
        while (current != null) {
            if (current.name.equals(name)) { // found delete it
                // case1: head
                if (current == head) {
                    if (head == tail) tail = null;
                    head = current.next;
                    current.next = null;// break reference from current
                }
                if (current == tail) {// case 2: tail
                    prev.next = null;
                    tail = prev;
                } else { // case 3: middle
                    prev.next = current.next;
                    current.next = null;
                }

                size--;
            }
            prev = current;
            current = current.next;

        }
    }
}
