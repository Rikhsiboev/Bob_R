package QueueProblem;

import java.util.Stack;

public class ReverseFirstKElementsQueueProblem {
    public static void main(String[] args) {
        MyQueueAllMethods<Integer> queue=new MyQueueAllMethods<>();
        for (int i = 1; i < 6; i++) {
            queue.enqueueAddFrontBack(i);
        }
        System.out.println("Initial queue: ");
        queue.printQueue();
        System.out.println();
        System.out.println("After reverse");
       reverseFirstK(queue,3).printQueue();
    }
    static MyQueueAllMethods<Integer> reverseFirstK(MyQueueAllMethods<Integer> queue, int k) {
        //create a stack
        Stack<Integer> stack = new Stack<>();
        // push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.dequeRemovingFromFront());
        }
        // enqueue elements back into the queue

        while (!stack.isEmpty()) {
            queue.enqueueAddFrontBack(stack.pop());
        }
        //dequeue and enqueue size of queue n-k times
        for (int i = 0; i < queue.size - k; i++) {
            queue.enqueueAddFrontBack(queue.dequeRemovingFromFront());
        }
        return queue;
    }


}
