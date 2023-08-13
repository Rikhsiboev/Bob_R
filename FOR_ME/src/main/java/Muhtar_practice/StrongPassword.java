package Muhtar_practice;

public class StrongPassword {
    public static void main(String[] args) {
        String str = "Bob4158997@";
        System.out.println(strongPassword(str));
    }

    public static boolean strongPassword(String str) {
        boolean answer = false;
        boolean mustBe8Chars = str.length() >= 8;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean hasDigit = false;
        boolean specialChar = false;

        if (str.contains(" ")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                upperCase = true;
            } else if (Character.isLowerCase(charAt)) {
                lowerCase = true;
            } else if (Character.isDigit(charAt)) {
                hasDigit = true;
            } else {
                specialChar = true;
            }
        }
        answer = mustBe8Chars && upperCase && lowerCase && hasDigit && specialChar;
        if (answer) {
            System.out.println(str + " Strong");
        } else {
            System.out.println(str + " not Strong ");
        }
        return answer;
    }
}
