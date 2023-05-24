package QueueProblem;

import java.util.NoSuchElementException;

public class MyQueueAllMethods<T> {
    // condition
    QueueNote<T> front;
    QueueNote<T> back;

    int size;

    //Empty
    boolean isEmpty() {
        return front == null;
    }

    //Peak or top
    T peak() {
        return (T) front.value;
    }

    //enqueue adding note
    void enqueueAddFrontBack(T item) {
        QueueNote<T> node = new QueueNote<>(item);

        if (isEmpty()) {
            front = back = node;
        } else {
            back.next = node;
            back = node;
        }
        size++;
    }



    T dequeRemovingFromFront() {
        QueueNote frontNode;
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        // for one element node or queue
        if (front == back) {
            frontNode = front;
            front = back = null;
        }
        // for more element node or queue
        else {
            frontNode = front;
            front = front.next;
        }
        size--;
        return (T) frontNode.value;
    }

    // size
    int size() {
        return size;
    }

    void printQueue(){
        if (isEmpty()) return;
        QueueNote<T> current=front;
        while(current!=null) {
            System.out.print(current.value);
            if(current.next!=null) System.out.print(", ");
            current=current.next;
        }
    }

}

