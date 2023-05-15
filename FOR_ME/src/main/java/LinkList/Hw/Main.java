package LinkList.Hw;

public class Main {
    public static void main(String[] args) {
        MyNote note = new MyNote();
        note.add(1);
        note.add(1);
        note.add(2);
        note.add(2);
        note.add(3);
        note.print();
        note.removeDuplicates();
        note.print();
    }
}
