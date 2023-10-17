package PrepFromYoutube;

import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4}; //Output: 24,12,8,6
        int[] nums2 = {-1, 1, 0, -3, 3}; //Output: 0,0,9,0,0
        System.out.println(Arrays.toString(except(nums1)));
        System.out.println(Arrays.toString(except(nums2)));
    }

    public static int[] except(int[] nums) {
        int[] result = new int[nums.length];
        int pre = 1;
        int suf = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suf;
            suf *= nums[i];
        }

        return result;
    }
}
