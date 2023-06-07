public class qs {
    public static void main(String[] args) {


        System.out.println(refactoringAndAddition(235807));
        System.out.println(otherMethod(235807));


    }

    private static int refactoringAndAddition(int i) {

        // 235807 => 2+3+5+8+0+7=>25

        while (i > 9) {
            int sum = 0;
            while (i > 0) {
                sum += i % 10; // for  it will be 7
                i /= 10;    // 23580
            }
            i = sum;
        }
        return i;
    }

    public static int otherMethod(int number){
        if (number<10){
            return number;
        }
        int sum=0;
        while (number > 0) {
            sum += number % 10; // for  it will be 7
            number /= 10;    // 23580
        }
        return otherMethod(sum);
    }
}
