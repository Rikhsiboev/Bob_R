package PrepInterview.LinkedList;

class NewNode {
    int val;
    NewNode next;

    NewNode(int x) {
        val = x;
        next = null;
    }
}

public class DuplicatesFromLinkedList {
    public static void main(String[] args) {
        NewNode node1 = new NewNode(1);
        NewNode node2 = new NewNode(1);
        NewNode node3 = new NewNode(3);
        NewNode node4 = new NewNode(4);
        NewNode node5 = new NewNode(4);
        NewNode node6 = new NewNode(4);
        NewNode node7 = new NewNode(5);
        NewNode node8 = new NewNode(6);
        NewNode node9 = new NewNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        NewNode result = removeDuplicates(node1);
        printList(result);
    }

    private static NewNode removeDuplicates(NewNode head) {
        if (head == null) return null;
        NewNode current = head;
        while (current.next != null) {
          if (current.val==current.next.val){
              current.next=current.next.next;
          }else {
              current=current.next;
          }
        }
        return head;
    }

    private static void printList(NewNode head) {
        NewNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void fatihSolution(NewNode head) {
        NewNode current = head;
        while (current != null) {
            NewNode nextDistinctNode = current.next;
            while (nextDistinctNode != null && nextDistinctNode.val == current.val) {
                nextDistinctNode = nextDistinctNode.next;
                current.next = nextDistinctNode;
                current = nextDistinctNode;
            }
        }
    }
}