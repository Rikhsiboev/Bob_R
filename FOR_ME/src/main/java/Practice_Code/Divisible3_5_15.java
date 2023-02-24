package Practice_Code;

public class Divisible3_5_15 {
    public static void main(String[] args) {


        String divisible15 = "";
        String divisible5 = "";
        String divisible3 = "";
        for (int i = 0; i <= 100; i++) {
            if (i % 15 == 0 && i % 3 == 0) {
                divisible15 += i + " ";
            } else if (i % 5 == 0 && i % 15 != 0) {
                divisible5 += i + " ";
            } else if (i % 3 == 0 && i % 15 != 0) {
                divisible3 += i + " ";
            }
        }

        System.out.println(" Divisible By 15: " + divisible15);
        System.out.println(" Divisible By 5: " + divisible5);
        System.out.println(" Divisible By 3: " + divisible3);


    }
}
/// steps
/**
 * create loop 1 to 100
 * if steatment with
 * 3
 * 5
 * 15
 */
/*
  int num = 100;
        String num15 = "";
        String num3 = "";
        String num5 = "";
        for (int i = 0; i <= num; i++) {

            /// i checked solution from get hup and understand logic

            if (i % 15 == 0 && i % 3 == 0) {
                num15 += i + " ";
            } else if (i % 5 == 0 && i % 15 != 0) {
                num5 += i+" ";
            } else if (i % 3 == 0 && i % 15 != 0) {
                num3 += i+" ";
            }

        }
        System.out.println(" Divisible By 15: " + num15);
        System.out.println(" Divisible By 5: " + num5);
        System.out.println(" Divisible By 3: " + num3);
    }
 */