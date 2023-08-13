package Muhtar_practice;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "ABCABCABC";
        System.out.println(duplicate(str));
    }

    public static String duplicate(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String charAt = "" + str.charAt(i);
            if (result.contains(charAt)) {
                continue;
            }
            result += charAt;
        }
        return result;
    }


}
