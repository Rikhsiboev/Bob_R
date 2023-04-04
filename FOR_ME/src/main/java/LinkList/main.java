package LinkList;


public class main {
    public static void main(String[] args) {
        //creating list
        Node myList = new Node();
        System.out.println("=====Adding to Tail====");
        myList.addTail(5);
        myList.addTail(10);
        myList.addTail(45);
        System.out.println("=====To Print ALL====");
        myList.print();
        System.out.println("=====Adding to Head====");
        myList.addToHead(50);
        myList.print();
        System.out.println("=====Adding After Current====");
        myList.addAfter(10,80);
        myList.print();
        System.out.println("================================");

        //creating list  => LiFo
        Node2 myList2 = new Node2();
        System.out.println("=====Adding to Tail====");
        myList2.addTail(5);
        myList2.addTail(10);
        myList2.addTail(45);
        myList2.print();
        System.out.println("=====REVERSE====");
        myList2.printAllReverse();
        System.out.println("=====Adding to head====");
        myList2.addToHead(25);
        System.out.println("=====Adding to Tail====");
        myList2.addAfter(10,1);

    }
}
