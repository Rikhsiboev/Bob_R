import java.util.Stack;

public class AnagramWithStack {

    public static boolean anagramWithStack(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.isEmpty() && stack.peek() == '{') {
               stack.pop();
            } else if (c==']' && stack.isEmpty()&& stack.peek()=='{') {
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
