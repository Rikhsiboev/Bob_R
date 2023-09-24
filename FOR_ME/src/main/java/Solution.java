import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> digitSumMap = new HashMap<>();
        int maxSum = -1;

        for (int num : A) {
            int firstDigit = num;
            while (firstDigit >= 10) {
                firstDigit /= 10;
            }

            int lastDigit = num % 10;
            int digitSum = firstDigit * 10 + lastDigit;

            if (digitSumMap.containsKey(digitSum)) {
                int otherNum = digitSumMap.get(digitSum);
                maxSum = Math.max(maxSum, num + otherNum);
                digitSumMap.put(digitSum, Math.max(otherNum, num));
            } else {
                digitSumMap.put(digitSum, num);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A1 = {130, 191, 200, 10};
        int[] A2 = {405, 45, 300, 300};
        int[] A3 = {50, 222, 49, 52, 25};
        int[] A4 = {30, 909, 3190, 99, 3990, 9009};

        System.out.println(solution.solution(A1)); // Output: 140
        System.out.println(solution.solution(A2)); // Output: 600
        System.out.println(solution.solution(A3)); // Output: -1
        System.out.println(solution.solution(A4)); // Output: 9918
    }
}
