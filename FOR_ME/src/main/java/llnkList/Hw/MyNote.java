package LinkList.Hw;


import LinkList.note.Node;

public class MyNote {

    private Node head;
    private Node tail;
    private int size;
    public MyNote() {
    }

    public MyNote(int size) {
        this.size = 0;
    }

    public void add(int value){
        Node node = new Node(value);
        if (head==null){
            head=node;
            tail=node;
        }else {
            tail.next=node;
            tail=node;
        }size++;
    }
    public void  print(){
        Node current = head;
        while (current !=null){
            System.out.print(current.value+" -> ");
            current=current.next;
        }
        System.out.println("end");
    }
    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


    public int getSize() {
        return size;
    }
}
