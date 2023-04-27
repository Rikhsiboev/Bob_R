package week15;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testNoCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode result = solution.detectCycle(head);
        assertNull(result);
    }

    @Test
    public void testCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        Solution solution = new Solution();
        ListNode result = solution.detectCycle(head);
        assertEquals(head.next, result);
    }
}
