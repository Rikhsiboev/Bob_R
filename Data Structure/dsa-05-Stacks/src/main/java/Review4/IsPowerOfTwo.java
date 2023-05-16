package Review4;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n==1) return true; // Base Condition
        if (n%2!=0 || n<=0) return false;
        return isPowerOfTwo(n/2);
    }
}
