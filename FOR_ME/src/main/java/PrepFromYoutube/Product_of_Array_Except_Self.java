package PrepFromYoutube;

import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4}; //Output: 24,12,8,6
//        int[] nums2 = {-1, 1, 0, -3, 3}; //Output: 0,0,9,0,0
        System.out.println(Arrays.toString(except1(nums1)));
//        System.out.println(Arrays.toString(except(nums2)));
    }

    public static int[] except(int[] nums) {
        // 1, 2, 3, 4
        int n = nums.length;
        int aPositive = 1;
        int bNegative = 1;
        int[] tempArray = new int[n];

        for (int i = 0; i < n; i++) {
            //1,2,3,4
            tempArray[i] = aPositive;  // 1,1,2,6
            aPositive *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            tempArray[i] *= bNegative;
            bNegative *= nums[i];
        }
        return tempArray;
    }

    public static int[] except1(int[] nums) {
        // 1, 2, 3, 4
        int n = nums.length;
        int[] answerOfArray = new int[n];
        int sum = 1;

        // Calculate the product of all elements in the array
        for (int i = 0; i < n; i++) {
            sum *= nums[i];
        }

        // Divide the product by each element at its respective index
        for (int i = 0; i < n; i++) {
            answerOfArray[i] = sum / nums[i];
        }

        return answerOfArray;
    }
}
