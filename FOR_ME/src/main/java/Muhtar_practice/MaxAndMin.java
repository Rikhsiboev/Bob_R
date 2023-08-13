package Muhtar_practice;

public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = {10, 5, -4, 20, 15};
        System.out.println(maxNumberOfArray(arr));
        System.out.println(minNumberOfArray(arr));
    }

    private static int maxNumberOfArray(int[] arr) {
        int max = arr[0];
        for (int each : arr) {
            if (each > max) {
                max = each;
            }
        }
        System.out.println("max");
        return max;
    }
    private static int minNumberOfArray(int[] arr) {
        int min = arr[0];
        for (int each : arr) {
            if (each < min) {
                min = each;
            }
        }
        System.out.println("min");
        return min;
    }
}
