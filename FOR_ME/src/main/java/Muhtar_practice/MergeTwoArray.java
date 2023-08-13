package Muhtar_practice;

import java.util.Arrays;

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {15, 20, 30, 5, 0};
        System.out.println(mergeTwoArray(arr1, arr2));
    }

    private static String mergeTwoArray(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length + arr2.length];
        int i = 0;
        for (int each : arr1) {
                newArray[i++]=each;
        }
        for (int each : arr2) {
            newArray[i++]=each;
        }
        return Arrays.toString(newArray);
    }
}
