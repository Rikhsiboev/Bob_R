package Practice_Code;

public class java {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1};   //1
        int[] arr1 = {4, 1, 2, 1, 2};//4
        System.out.println(oneNumber(arr));
        System.out.println(oneNumber(arr1));
    }

    public static int oneNumber(int[] num) {

        for (int i = 0; i < num.length; i++) {
            int answer = 0;
            for (int j = 0; j < num.length; j++) {
                if (num[i] == num[j]) {
                    answer += 1;
                }
            }
            if (answer==1)
            return num[i];
        }

        return 0;
    }






}