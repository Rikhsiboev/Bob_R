package stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class maxBodybuilding {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9};
        System.out.println(solutionOfMaxBuilding(arr));
    }

    public static List<Integer> solutionOfMaxBuilding(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()){
                result.add(arr[i]);
            }
            stack.push(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }


}
