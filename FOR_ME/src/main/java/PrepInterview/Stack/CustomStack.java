package PrepInterview.Stack;

public class CustomStack {
    private int maxSize;
    private int[] stack;
    private int[] incDiff;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.incDiff = new int[maxSize];
    }

    public void push(int x) {
        if (stack.length < maxSize) {
            stack[stack.length] = x;
        }
    }

    public int pop() {
        if (stack.length == 0) {
            return -1;
        }
        int index = stack.length - 1;
        if (index > 0) {
            incDiff[index - 1] += incDiff[index];
        }
        int poppedValue = stack[index] + incDiff[index];
        stack[index] = 0;
        incDiff[index] = 0;
        return poppedValue;
    }

    public void increment(int k, int val) {
        k = Math.min(k, stack.length);
        if (k>0){
            incDiff[k-1] +=val;
        }
    }


    public static void main(String[] args) {
        CustomStack stk = new CustomStack(3);
        System.out.println(stk.pop()); // -1
        stk.push(1);
        stk.push(2);
        System.out.println(stk.pop()); // 2
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.increment(5, 100);
        stk.increment(2, 100);
        System.out.println(stk.pop()); // 103
        System.out.println(stk.pop()); // 202
        System.out.println(stk.pop()); // 201
        System.out.println(stk.pop()); // -1
    }
}



