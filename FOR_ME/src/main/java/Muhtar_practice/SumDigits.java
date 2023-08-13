package Muhtar_practice;

public class SumDigits {
    public static void main(String[] args) {
        String str = "A1B2C3D4";
        System.out.println(sumDigits(str));
    }

    public static int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sum += Integer.parseInt("" + charAt);
            }
        }
        return sum;
    }
}
