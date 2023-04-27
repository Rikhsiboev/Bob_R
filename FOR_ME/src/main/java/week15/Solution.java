package week15;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                ListNode curr = head;
                while (curr != tortoise) {
                    curr = curr.next;
                    tortoise = tortoise.next;
                }
                return curr;
            }
        }
        return null;
    }
}
