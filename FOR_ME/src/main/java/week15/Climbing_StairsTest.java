package week15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Climbing_StairsTest {

    @Test
    public void testClimbStairs() {
        Climbing_Stairs cs = new Climbing_Stairs();
        assertEquals(1, cs.climbStairs(1));
        assertEquals(2, cs.climbStairs(2));
        assertEquals(3, cs.climbStairs(3));
        assertEquals(5, cs.climbStairs(4));
        assertEquals(8, cs.climbStairs(5));
        assertEquals(13, cs.climbStairs(6));
        assertEquals(21, cs.climbStairs(7));
    }

    @Test
    public void testClimbStairsPositive() {
        Climbing_Stairs cs = new Climbing_Stairs();
        assertEquals(1, cs.climbStairs(1));
        assertEquals(2, cs.climbStairs(2));
        assertEquals(3, cs.climbStairs(3));
        assertEquals(5, cs.climbStairs(4));
        assertEquals(8, cs.climbStairs(5));
        assertEquals(13, cs.climbStairs(6));
        assertEquals(21, cs.climbStairs(7));
    }

    @Test
    public void testClimbStairsNegative() {
        Climbing_Stairs cs = new Climbing_Stairs();
        assertNotEquals(3, cs.climbStairs(1));
        assertNotEquals(5, cs.climbStairs(2));
        assertNotEquals(8, cs.climbStairs(3));
        assertNotEquals(13, cs.climbStairs(4));
        assertNotEquals(21, cs.climbStairs(6));
        assertNotEquals(34, cs.climbStairs(7));
    }

}