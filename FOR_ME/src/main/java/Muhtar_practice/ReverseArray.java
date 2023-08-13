package Muhtar_practice;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {10, 5, 38, 15, 0};
        System.out.println(reverseArray(arr));
    }

    public static String reverseArray(int[] arr) {
        int[] newAArray = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            newAArray[j] = arr[i];
        }
        return Arrays.toString(newAArray);
    }
}
