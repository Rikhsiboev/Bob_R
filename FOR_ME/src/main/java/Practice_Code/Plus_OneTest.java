package Practice_Code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Plus_OneTest {
    @Test
    public void testPlusOne() {
        int[] digits1 = {1, 2, 3};
        int[] digits2 = {4, 3, 2, 1};
        int[] digits3 = {9};

        assertArrayEquals(new int[]{1, 2, 4}, Plus_One.plusOne(digits1));
        assertArrayEquals(new int[]{4, 3, 2, 2}, Plus_One.plusOne(digits2));
        assertArrayEquals(new int[]{1, 0}, Plus_One.plusOne(digits3));

    }
    @Test
    public void testPlusOneWithSingleDigit() {
        int[] digits = {0};
        int[] expected = {1};
        assertArrayEquals(expected, Plus_One.plusOne(digits));
    }

    @Test
    public void testPlusOneWithMultipleDigits() {
        int[] digits = {1, 2, 3};
        int[] expected = {1, 2, 4};
        assertArrayEquals(expected, Plus_One.plusOne(digits));
    }

    @Test
    public void testPlusOneWithCarryOver() {
        int[] digits = {9, 9, 9};
        int[] expected = {1, 0, 0, 0};
        assertArrayEquals(expected, Plus_One.plusOne(digits));
    }

}