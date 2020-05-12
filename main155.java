package Leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class main155 {
    /**
     * 方法1： 利用辅助栈
     * initialize your data structure here.
     * <p>
     * private Stack<Integer> stack;
     * private Stack<Integer> minStack; // 利用了辅助栈
     * public MinStack() {
     * stack = new Stack<>();
     * minStack = new Stack<>();
     * }
     * <p>
     * public void push(int x) {
     * stack.push(x);
     * if (!minStack.isEmpty()) {
     * int top = minStack.peek();
     * if (x <= top) {
     * minStack.push(x);
     * }
     * } else {
     * minStack.push(x);
     * }
     * }
     * <p>
     * public void pop() {
     * int pop = stack.pop();
     * <p>
     * int top = minStack.peek();
     * // 如果等于才出栈
     * if (top == pop) {
     * minStack.pop();
     * }
     * }
     * <p>
     * public int top() {
     * return stack.peek();
     * }
     * <p>
     * public int getMin() {
     * return minStack.peek();
     * }
     */

    /**
     * 方法2： 只用一个栈
     */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        // 当前值更小
        if (x <= min) {
            // 将之前的最小值保存
            stack.push(min);
            // 更新最小值
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 如果弹出的值是最小值，那么将下一个元素更新为最小值
        if (stack.pop() == min) {
            min = stack.pop();  // 这里会再连续删除一个
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
