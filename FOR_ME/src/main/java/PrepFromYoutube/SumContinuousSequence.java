package PrepFromYoutube;

public class SumContinuousSequence {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in); //input for inputArr
//        int inputArr_size = input.nextInt();
//        int inputArr[] = new int[inputArr_size];
//
//
//        for(int i = 0; i<= inputArr_size; i++){
//            inputArr[i] = input.nextInt();
//        }
//
//        int result = funcSum (inputArr);
//        System.out.print(result);
//        return maxSoFar;
    }

    public static int funcSum1(int[] inputArr1) {
        //2, -8, 3, -2, 4, -10)
        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum to a very small value
        int currentSum = 0;  // Initialize currentSum to 0

        for (int i = 0; i < inputArr1.length; i++) {
            currentSum = Math.max(inputArr1[i], currentSum + inputArr1[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int funcSum2(int[] inputArr2) {
        int size = inputArr2.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int i = 0; 1 < size; i++) {
            maxEndingHere = maxEndingHere + inputArr2[i];
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
    // Kadane's Algorithm
/*Initialize:
max_so_far = INT_MIN
max_ending_here = 0
•
Loop for each element of the array
(a) max_ending_here = max_ending_here + a[i]
(b) if (max_so_far < max_ending_here)
max_so_far = max_ending_here
(c)  if (max_ending_here < 0)
max_ending_here = 0*
You, Today • Uncommitted changes
return max_so_far/
*/
}
