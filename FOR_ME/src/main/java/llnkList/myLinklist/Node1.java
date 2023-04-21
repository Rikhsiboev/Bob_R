package LinkList.myLinklist;

public class Node1 {
    int value;
    Node1 next;

    private Node1 head;
    private Node1 tail;
    private int size;

    Node1(){
        this.size=0;
    }

    public Node1(int value) {
        this.value = value;
    }

    public Node1(int value, Node1 next) {
        this.value = value;
        this.next = next;
    }

    public void print(){
        Node1 current = head;
        while (current!=null){
            System.out.println(current.value+"->");
            current = current.next;
        }
        System.out.println("end");
    }


}
