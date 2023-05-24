package Heap;

public class HeapApp {
    public static void main(String[] args) {

        MyHeap myHeap = new MyHeap(10);
        myHeap.insert(61);
        myHeap.insert(120);
        myHeap.insert(52);
        myHeap.insert(45);
        myHeap.insert(81);
        myHeap.printHeap();
        System.out.println(myHeap.remove());
        System.out.println(" Heap values after inserting 81 ");
        myHeap.printHeap();



    }
}
