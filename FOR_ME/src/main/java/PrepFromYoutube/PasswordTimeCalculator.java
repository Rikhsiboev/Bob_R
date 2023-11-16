package PrepFromYoutube;

public class PasswordTimeCalculator {
    public static void main(String[] args) {
        int n = 147; // Total number of passwords
        int k = 1; // Number of wrong attempts allowed

        int bestCaseTime = calculateBestCaseTime(n);
        int worstCaseTime = calculateWorstCaseTime(n, k);

        System.out.println("Best-case time: " + bestCaseTime + " seconds");
        System.out.println("Worst-case time: " + worstCaseTime + " seconds");
    }

    public static int calculateBestCaseTime(int n) {
        return 1; // In the best case, it takes only 1 second to enter the correct password
    }

    public static int calculateWorstCaseTime(int n, int k) {
        int waitingTime = 5; // Waiting time in seconds after each wrong attempt

        int wrongAttempts = k;
        int remainingPasswords = n - 1; // Excluding the correct password

        int worstCaseTime = 1; // Time for the first attempt

        while (wrongAttempts > 0 && remainingPasswords > 0) {
            worstCaseTime += waitingTime; // Waiting time after each wrong attempt
            wrongAttempts--;
            remainingPasswords--;
        }

        worstCaseTime += remainingPasswords * waitingTime; // Time for entering the remaining correct passwords

        return worstCaseTime;
    }
}
