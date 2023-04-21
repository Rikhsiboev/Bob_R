package llnkList;

public class PalindromeList {
//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//
//        // check if the list is a palindrome
//        boolean result = isPalindrome(head);
//
//        // print the result
//        System.out.println(result);
//
//
//
//    }
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true; // an empty or single-node list is always a palindrome
//        }
//        // find the middle node using the slow/fast pointer technique
//        ListNode slow = head, fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        // reverse the second half of the list
//        ListNode prev = null, curr = slow, next = null;
//        while (curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        // compare the first half of the list with the reversed second half
//        ListNode p1 = head, p2 = prev;
//        while (p2 != null) {
//            if (p1.val != p2.val) {
//                return false;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return true;
//    }

}
