package PrepFromYoutube;

public class FibonacciStairs {
    public static void main(String[] args) {
        System.out.println("----");
        System.out.println(climbStairsArr(2));
        System.out.println(climbStairsArr(3));
        System.out.println(climbStairsArr(5));
        System.out.println(climbStairsArr(20));
    }

    public static int climbStairsArr(int n){

        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;

        if (n<2)return n;
        for (int i = 2; i <n ; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n-1];


    }


}

/*
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * /***Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

