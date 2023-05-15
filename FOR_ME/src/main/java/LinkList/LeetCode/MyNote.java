package LinkList.LeetCode;

import LinkList.note.Node;

public class MyNote {
    Note head;
    Note tail;
    int size;

    public MyNote() {
    }

    public MyNote(int size) {
        this.size = 0;
    }

    public void add (int value){
        Note note = new Note(value);
        if (head == null){
            head = tail=note;
        }else {
            tail.next=note;
            tail=note;
        }size++;
    }
    public void print (){
        Note current = head;
        while (current!=null){
            System.out.print(current.value+" -> ");
            current=current.next;
        }
        System.out.println("End");
    }

    public void remove(int value){
        /// null while if
        /// 1 2 3
        if (head==null)return;
        if (head.value==value){
            head=head.next;
        }
        Note current = head;
        while (current.next!=null&& current.next.value!=value){
            current=current.next;
        }
        if (current.next!=null&& current.next.value==value){
            current.next=current.next.next;return;
        }
        if (tail.value==value){
            tail=current;
            tail.next=null;
            return;
        }
    }




}
