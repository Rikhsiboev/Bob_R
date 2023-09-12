package PrepInterview.gasStattion;

public class gasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 1};
        //-2 -2 -2  3  4 ===1
        System.out.println(calculate(gas, cost));
    }

    public static int calculate(int[] gas, int[] cost) {
            int totalGas=0;
            int currentGas=0;
            int result=0;
        for (int i = 0; i < gas.length ; i++) {
            int diff= gas[i]-cost [i];
            totalGas+=diff;
            currentGas+=diff;
            if (currentGas<0){
                currentGas=0;
                result=i+1;
            }
        }

        if (totalGas<0){
            return -1;
        }
        return result;

    }
}



