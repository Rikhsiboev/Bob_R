package PrepFromYoutube;

import java.util.Stack;

public class backspaceCompare {
    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        String s2 = "ab##";
        String t2 = "c#d#";
        String s3 = "a#c";
        String t3 = "b";
        System.out.println(backspaceCompare(s1, t1));
        System.out.println(backspaceCompare(s2, t2));
        System.out.println(backspaceCompare(s3, t3));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stackS.push(s.charAt(i));
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stackT.push(t.charAt(i));
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }

        return stackS.equals(stackT);

    }
}
