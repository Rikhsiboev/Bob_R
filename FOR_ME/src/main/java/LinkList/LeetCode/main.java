package LinkList.LeetCode;

public class main {
    public static void main(String[] args) {

        MyNote myNote = new MyNote();
        myNote.add(1);
        myNote.add(2);
        myNote.add(3);
        myNote.add(4);
        myNote.add(5);
        myNote.add(6);
        myNote.add(7);
        myNote.print();
        myNote.remove(1);
        myNote.print();
        myNote.remove(3);
        myNote.print();
        myNote.remove(7);
        myNote.print();
    }
}
