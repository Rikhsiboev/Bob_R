package Review4;

public class MySinglyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

  void addFirst(T t){
      // create a new node object from data
      Node<T> node=new Node(t);
     // case 1: list empty
      if(isEmpty()){
       head=tail=node;
      } else{// case 2 : list is not empty
          node.next=head;
          head=node;
      }
      //increase size
      size++;
  }
  T removeFirst(){
        if (isEmpty()) return null;
        T result=null;
        if (head==tail){
            result=head.value;
            head=tail=null;
        }else {
            result=head.value;
            head=head.next;
        }
        size--;
        return result;
  }

    void printNodes(){
        Node<T> current=head;
        while(current!=null){
            if (current.next==null) System.out.println(current.value+"=> null");
            else {
            System.out.print(current.value+"=> ");
            }
            current=current.next;
        }
  }

}