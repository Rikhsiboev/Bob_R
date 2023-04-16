package LinkList.myLinklist;

public class NoteCreating {
    private Node1 head;
    private Node1 tail;
    private int size;

    public NoteCreating() {
        this.size = 0;
    }

    public void add(int value) {
        Node1 node = new Node1(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    public void print(){
        Node1 current = head;
        while (current!=null){
            System.out.print(current.value+"->");
            current=current.next;
        }
        System.out.println("end");
    }

}
