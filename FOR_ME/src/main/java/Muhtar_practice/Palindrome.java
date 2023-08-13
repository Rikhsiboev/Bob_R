package Muhtar_practice;

public class Palindrome {
    public static void main(String[] args) {
        String str = "LeVEl";
        System.out.println(palindromeMethod(str));
    }

    public static String palindromeMethod(String str) {
        String reverseStringTemp = "";
        String answer = null;
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStringTemp += str.charAt(i);
        }
        if (str.equalsIgnoreCase(reverseStringTemp)) {
            answer = "palindrome";
        } else {
            answer = "not palindrome";
        }
        return answer;
    }
}
