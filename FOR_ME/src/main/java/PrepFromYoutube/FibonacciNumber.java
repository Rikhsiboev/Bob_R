package PrepFromYoutube;

import java.util.stream.Stream;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println("this is answer "+fib(6));
    }
    public static int fib(int n){
        if (n<2){
            System.out.println(n);
            return n;
        }else {
            System.out.println(n);
            return fib(n-1)+fib(n-2);
        }
    }

    public static int fibStream(int n){
        if (n>2){
            return n;
        }else {
            return Stream.iterate(
                    new int[]{0,1},
                    fib->new int[]{fib(1),
                            fib[0]+fib[1]})
                    .limit(n+1)
                    .mapToInt(fib->fib(0))
                    .reduce((a,b)->b)
                    .orElse(0);
        }

    }

}
