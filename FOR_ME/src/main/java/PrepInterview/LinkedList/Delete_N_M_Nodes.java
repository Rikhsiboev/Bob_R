package PrepInterview.LinkedList;

public class Delete_N_M_Nodes {

    static class NoteDelete {
        int val;
        Delete_N_M_Nodes.NoteDelete next;

        public NoteDelete(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        NoteDelete note1 = new NoteDelete(1);
        NoteDelete note2 = new NoteDelete(2);
        NoteDelete note3 = new NoteDelete(3);
        NoteDelete note4 = new NoteDelete(4);
        NoteDelete note5 = new NoteDelete(5);
        NoteDelete note6 = new NoteDelete(6);
        NoteDelete note7 = new NoteDelete(7);
        NoteDelete note8 = new NoteDelete(8);
        NoteDelete note9 = new NoteDelete(9);
        NoteDelete note10 = new NoteDelete(10);
        NoteDelete note11 = new NoteDelete(11);
        NoteDelete note12 = new NoteDelete(12);
        NoteDelete note13 = new NoteDelete(13);
        note1.next = note2;
        note2.next = note3;
        note3.next = note4;
        note4.next = note5;
        note5.next = note6;
        note6.next = note7;
        note7.next = note8;
        note8.next = note9;
        note9.next = note10;
        note10.next = note11;
        note11.next = note12;
        note12.next = note13;
        print(note1);
        NoteDelete noteDelete = deleteNAfterM(note1, 2, 3);
        print(noteDelete);
    }

    public static NoteDelete deleteNAfterM(NoteDelete head, int n, int m) {

        if (head == null || head.next == null) return null;

        NoteDelete current = head;
        NoteDelete prev = null;
        int keepM = m;
        int skipN = n;

        while (current != null) {
            for (int i = 0; i < keepM && current != null; i++) {
                prev = current;
                current = current.next;
            }
            for (int i = 0; i < skipN && current != null; i++) {
                current = current.next;
            }

            if (prev != null) {
                prev.next = current;
            }

        }
        return head;
    }

    public static void print(NoteDelete head) {
        NoteDelete current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
