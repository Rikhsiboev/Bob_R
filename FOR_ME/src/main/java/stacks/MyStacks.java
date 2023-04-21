package stacks;

import java.util.NoSuchElementException;

public class MyStacks <T>{
    public StacksNote <T> bottom;  //head
    public StacksNote <T> top;      //Tail
    int size;                       //size

    public boolean isEmpty(){       //empty
        return bottom==null;
    }

        public void push (T item) { // adding tail
            StacksNote<T> note = new StacksNote<>(item);
            if (isEmpty()){
                bottom=top=note;
            }else {
                top.next=note;
                top=note;
            }size++;
        }

        public T peak(){  // current value
        return (T)top.value;
        }

        public T pop(){    // removing
        StacksNote peekNote;
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        // stock has one element
            if (top==bottom){
                peekNote=top;
                top=bottom=null;
            }else { // more than one element
                peekNote=top;
                StacksNote prev = bottom;
                while (prev.next!=top){
                    prev=prev.next;
                }
                prev.next=null;
                top=prev;
            }size--;return (T) peekNote.value;
        }
}
