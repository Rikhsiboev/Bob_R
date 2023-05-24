package Heap;

import java.util.NoSuchElementException;

public class MyHeap {
    //condition
    int[] items;
    int size;

    // i need capacity
    public MyHeap(int capacity) {
        this.items = new int[capacity];
        this.size = 0;
    }

    // left and right child and parent address
    public int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    public int largeChildIndex(int index) {
        // no child
        if (!hasLeftChild(index)) {
            return index;
        }//one child Left Child
        else if (hasRightChild(index)) {
            return leftChildIndex(index);
        } else {
            return items[leftChildIndex(index)] > items[rightChildIndex(index)] ? leftChildIndex(index) : rightChildIndex(index);

            //    if (items[leftChildIndex(index)]>items[rightChildIndex(index)]){
            //        return leftChildIndex(index);
            //    }else {
            //        return rightChildIndex(index);
        }
    }

    public void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        } else {
            boolean isValid = items[index] > items[leftChildIndex(index)];
            if (hasRightChild(index)) {
                isValid = items[index] >= items[rightChildIndex(index)];
            }
            return isValid;
        }
    }


    public void insert(int value) {
        if (size == items.length) {
            throw new NoSuchElementException();
        } else {
            items[size++] = value;

            bubbleUp();
        }

    }

    void bubbleUp(){
        //calculate start point/index
        int index=size-1;
        //while index >0 && parent is less than child continue
        // 1 swap the parent and child
        // calculate next index  = parent index
        while (index>0 && items[index]>items[parentIndex(index)]){
            swap(index,parentIndex(index));
            // assign the next index with the parent index
            index=parentIndex(index);

        }
    }

    public int remove (){
        if (size==0){
            throw new NoSuchElementException();
        }else {
            int result=items[0];
            items[0]=items[--size];
            bubbleDown();
            return result;
        }
    }

    public void bubbleDown(){
        int index = 0 ;
        int largerChildIndex;
        while (index<=size && isValidParent(index)){
            largerChildIndex=largeChildIndex(index);
            swap(index,largerChildIndex);
            index=largerChildIndex;
        }
    }

    public void printHeap(){
        for (int i = 0; i <size ; i++) {
            System.out.print(items[i]+", ");
        }
        System.out.println();
    }

}

