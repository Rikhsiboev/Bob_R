package Stacks;

public class StockApp {
    public static void main(String[] args) {

        MyStacks<Integer> stack = new MyStacks<>();
        for (int i = 0; i <5 ; i++) {
            stack.push(i);
        }
        System.out.println(stack.peak());

        stack.push(10);

        for (int i = 0; i <5 ; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.peak());
    }
}
