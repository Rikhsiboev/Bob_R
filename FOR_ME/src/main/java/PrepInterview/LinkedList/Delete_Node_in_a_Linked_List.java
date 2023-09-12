package PrepInterview.LinkedList;

public class Delete_Node_in_a_Linked_List {
    static class NoteForThis {
        int val;
        NoteForThis next;

        public NoteForThis(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        NoteForThis note1 = new NoteForThis(4);
        NoteForThis note2 = new NoteForThis(5);
        NoteForThis note3 = new NoteForThis(1);
        NoteForThis note4 = new NoteForThis(9);
        note1.next = note2;
        note2.next = note3;
        note3.next = note4;

        int valueToDelete = 5; // Specify the value to delete

    }

    private static void deleteNode( NoteForThis note) {
        NoteForThis current = note;
        current.val= current.next.val;
        current.next=current.next.next;
    }

    private static void printList(NoteForThis head) {
        NoteForThis current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }



}
