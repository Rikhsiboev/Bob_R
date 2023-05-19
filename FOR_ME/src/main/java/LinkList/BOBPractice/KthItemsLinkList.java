package LinkList.BOBPractice;

public class KthItemsLinkList {
    Node head;
    Node tail;
    int size;


    public int getKthItemFromLast(int k){
        //singing two point with head
        Node pointer1 = head;
        Node pointer2 = head;
        // I need loop for k to find
        for (int i =0; i<k-1;i++){
            pointer2=pointer2.next;
        }
        // now I have to move together
        while (pointer2.next!=null){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }//pointer1 is on the kth element from the last
        return pointer1.date;


    }



}
