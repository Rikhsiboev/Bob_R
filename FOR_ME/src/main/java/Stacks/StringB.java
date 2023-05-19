package Stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class StringB {
    public static void main(String[] args) {

        System.out.printf(reverseOfStringWithStockMethod("Bobur"));


    }

    //Time complexity: O(n)
    //Space complexity: O(n)

    public static String reverseOfStringWithStockMethod(String parameterFromUser) {
        // 1-step  create our stack
        Stack <String> ourStack = new Stack<>();
        // 2-step get each element of our string
        for (int i = 0; i <parameterFromUser.length() ; i++) {
            char c = parameterFromUser.charAt(i);
            ourStack.push(String.valueOf(c));
        }

       // 3- step creating boulder and while loop
        StringBuilder stringBuilder = new StringBuilder();


        while (!ourStack.isEmpty()){
            String pop = ourStack.pop();
            stringBuilder.append(pop);
        }

        // 4 returning stringBuilder
        return stringBuilder.toString();


    }
}
