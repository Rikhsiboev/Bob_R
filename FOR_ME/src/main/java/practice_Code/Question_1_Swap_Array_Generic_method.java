package Practice_Code;

import java.util.Arrays;


public  class Question_1_Swap_Array_Generic_method {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
        String[] str = {"Java","Python","C++","Maven"};
        swap(a, 0, 2);
        System.out.println(Arrays.toString(a));
        swap(str,"Python","C++");
        System.out.println(Arrays.toString(str));
        swap(str,0,3);
        System.out.println(Arrays.toString(str));
    }
                // method for integer
    public static  <T> void swap(T[] ArrayName, Integer firstIndex, Integer lastIndex) {
        T temp = ArrayName[firstIndex];
        ArrayName[firstIndex] = ArrayName[lastIndex];
        ArrayName[lastIndex] = temp;
    }
            // overridden method for using String
    public static <T> void swap(T[] ArrayName, T firstIndex, T lastIndex) {
        int indexA = -1; ///that means not empty => -1
        int indexB = -1;

        // trying to find index number of Dsa_02_Array
        for (int i = 0; i < ArrayName.length; i++) {
            if (ArrayName[i].equals(firstIndex)) {
                indexA = i;
            }
            if (ArrayName[i].equals(lastIndex)) {
                indexB = i;
            }
        }

        // swap method
        if (indexA != -1 && indexB != -1) {
            T temp = ArrayName[indexA];
            ArrayName[indexA] = ArrayName[indexB];
            ArrayName[indexB] = temp;
        }
    }
    




}

/* Write a generic method to exchange the positions of two different elements in array.
Sample output:
Integer[] a = {1,2,3,4};
swap(a,0,2); System.out.println(Arrays.toString(a)); //[3,2,1,4]*/