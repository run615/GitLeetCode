package Leetcode;

import java.util.Stack;

public class main0304 {
    /** Initialize your data structure here. */
    Stack<Integer> aStack;
    Stack<Integer> bStack;
    //public MyQueue() {
    //    aStack = new Stack<>();
    //    bStack = new Stack<>();
    //}

    /** Push element x to the back of queue. */
    public void push(int x) {
        aStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(aStack.size() != 1){
            bStack.push(aStack.pop());
        }
        int pop = aStack.pop();
        while(bStack.size() > 0){
            aStack.push(bStack.pop());
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        while(aStack.size() != 1){
            bStack.push(aStack.pop());
        }
        int peek = aStack.peek();
        while(bStack.size() > 0){
            aStack.push(bStack.pop());
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(aStack.size() == 0){
            return true;
        }
        return false;
    }
}
