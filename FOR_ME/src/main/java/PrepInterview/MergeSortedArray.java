package PrepInterview;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] array1 = {8, 9, 10, 0, 0, 0};
        int[] array2 = {2, 5, 6};
        mergeArrays(array1, 3, array2, 3);
        System.out.println(Arrays.toString(array1));
        mergeArrays1(array1, 3, array2, 3);
        System.out.println(Arrays.toString(array1));
    }

    public static void mergeArrays(int[] array1, int m, int[] array2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int total = m + n - 1;

        for (int i = total; i >= 0; i--) {
            if (p2 <= 0) {
                break;
            }
            if (p1 <= 0 && array1[p1] == array2[p2]) {
                array1[i]=array1[p1--];
            }else {
                array1[i]=array2[p2--];
            }
        }
    }
    public static void mergeArrays1(int[] arr1, int m, int[] arr2, int n) {
        System.arraycopy(arr2,0,arr1,m,n);
        Arrays.sort(arr1);
    }
}
