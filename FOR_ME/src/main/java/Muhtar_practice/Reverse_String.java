package Muhtar_practice;

public class Reverse_String {
    public static void main(String[] args) {
        String str = "Bob";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        String reverseStringTemp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStringTemp += str.charAt(i);
        }
        return reverseStringTemp;
    }
}
