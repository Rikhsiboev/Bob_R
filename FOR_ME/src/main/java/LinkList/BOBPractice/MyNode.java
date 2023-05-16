package LinkList.BOBPractice;

public class MyNode {
    Node head;
    Node tail;
    int size;

    void print(){
        Node current = head;
        while (current!=null){
            System.out.println(current.date+" => ");
            current=current.next;
        }
    }

    void addNode(int date){
        //new note
        Node node = new Node(date);
            // case 1 empty
        if (head == null){
            head=tail=null;
            // not empty
        }else {
            node.next=head;
            head=node;
            //size++
        }size++;
    }





}
