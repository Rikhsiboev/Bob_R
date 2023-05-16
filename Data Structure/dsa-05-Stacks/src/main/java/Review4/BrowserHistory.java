package Review4;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    // declare stacks and current
    Deque<String> history, forwardStack;
    String currentPage;

    public BrowserHistory(String homepage) {
        // initialize stacks and current=homepage
        history = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        currentPage = homepage;
    }

    public void visit(String url) {
        // Push 'current' in 'history' stack and mark 'url' as 'current'.
        history.push(currentPage);
        currentPage = url;
        System.out.println(url +" is visited");
        forwardStack = new ArrayDeque<>();
    }

    public String back(int steps) {
        int steps2=steps;
        // Pop elements from 'history' stack, and push elements in 'forward' stack.
        while (steps > 0 && !history.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = history.pop();
            steps--;
        }
        System.out.println("Back operation of " + steps2 + " brings " + currentPage);
        return currentPage;
    }

    public String forward(int steps) {
        int steps2=steps;
        // Pop elements from 'forward' stack, and push elements in 'history' stack.
        while (steps > 0 && !forwardStack.isEmpty()){
            history.push(currentPage);
            currentPage = forwardStack.pop();
            steps--;
        }
        System.out.println("Forward operation of " + steps2 + " brings " + currentPage);
        return currentPage;
    }

}
