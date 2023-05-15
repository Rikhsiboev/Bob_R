package LinkList.myLinklist;

public class main {
    public static void main(String[] args) {

        Node1 a= new Node1(5);
        Node1 b= new Node1(5);
        Node1 c= new Node1(5);
        Node1 d= new Node1(5);
        a.next=b;
        b.next=c;
        c.next=d;//=> a b c d null
        d.print();



    }
}
