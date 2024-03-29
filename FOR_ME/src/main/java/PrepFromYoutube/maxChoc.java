package PrepFromYoutube;

import java.util.Scanner;

public class maxChoc {
    public static void main(String[] args) {
        Scanner inputFromUser = new Scanner(System.in); //input for inputArr
        int inputArr_size = inputFromUser.nextInt();
        int[] array = new int[inputArr_size];
        for (int i = 0; i < inputArr_size; i++) {
            array[i] = inputFromUser.nextInt();
        }

        System.out.println(maxSum(array));
    }

    public static int maxChocolates(int[] inputArr) {
        int n = inputArr.length;
        int[] maxChocolates = new int[n];
        maxChocolates[0] = inputArr[0];
        maxChocolates[1] = Math.max(inputArr[0], inputArr[1]);
        for (int i = 2; i < n; i++) {
            maxChocolates[i] = Math.max(maxChocolates[i - 1], maxChocolates[i - 2] + inputArr[i]);
        }
        return maxChocolates[n - 1];
    }

    public static int maxSum(int[] array) {
        // 6 ind add in our array as index
        // 5 30 99 60 5 10
        // we have to find dynamic function
        // if we select
        // sum =  5 + 99 + 10   =>114   answer
        // sum = 30 + 60 + 5       =>95  but best option to select second option

        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];

        int getChoc = 0;
        int notGetChoc = 0;

        for (int i = 0; i < array.length; i++) {
            int temp = getChoc;
            getChoc = Math.max(notGetChoc + array[i], getChoc);
            notGetChoc = temp;
        }
        return getChoc;

    }


}
