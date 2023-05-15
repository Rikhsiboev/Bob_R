package LinkList.REVERSE_RECRUTION;

public class Solution {
    public NoteReverseAndRecreation reverse(NoteReverseAndRecreation head) {
        NoteReverseAndRecreation prev = null;
        NoteReverseAndRecreation current = head;
        NoteReverseAndRecreation next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public NoteReverseAndRecreation recreation(NoteReverseAndRecreation head){
        if (head==null||head.next==null){
            return head;
        }
        NoteReverseAndRecreation recreationHead = recreation(head.next);
        head.next.next=head;
        head.next=null;
        return recreationHead;

    }
}
