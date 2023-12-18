package PrepFromYoutube;

import java.util.Arrays;

public class Two_Sum_2 {
    public static void main(String[] args) {
        int[] array1 = {2, 7, 15, 45};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSumTwo(array1, target1)));
//        int[] array2 = {3, 2, 4};
//        int target2 = 6;
//        System.out.println(Arrays.toString(twoSumTwo(array2, target2)));
//        int[] array3 = {3, 3};
//        int target3 = 6;
//        System.out.println(Arrays.toString(twoSumTwo(array3, target3)));
    }

    public static int[]twoSumTwo(int [] nums,int  target){

        int l =0;
        int r = nums.length-1;
        while(nums[l]+nums[r] != target){
            if(nums[l]+nums[r]<target){
                l++;
            }else {
                r--;
            }
        }
        return new int[]{l+1,r+1};

    }

}
