package Leetcode;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 */
public class main150 {
    public int evalRPN(String[] tokens) {
        /**
         * 我写的
         */
        //Stack<Integer> stack = new Stack<>();
        //for (int i = 0; i < tokens.length; i++) {
        //    if (tokens[i].equals("+")) {
        //        stack.push(stack.pop() + stack.pop());
        //    } else if (tokens[i].equals("-")) {
        //        int jian = stack.pop();
        //        int beijian = stack.pop();
        //        stack.push(jian - beijian);
        //    } else if (tokens[i].equals("*")) {
        //        stack.push(stack.pop() * stack.pop());
        //    } else if (tokens[i].equals("/")) {
        //        int beichu = stack.pop();
        //        int chu = stack.pop();
        //        stack.push(chu / beichu);
        //    } else {
        //        //stack.push(Integer.parseInt(tokens[i]));
        //        stack.push(Integer.valueOf(tokens[i]));
        //    }
        //}
        //return stack.pop();

        /**
         * 用switch语句
         */
        Stack<Integer> stack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        main150 p = new main150();
        String[] tokens = new String[]{
                "2", "1", "+", "3", "*"
        };
        int res = p.evalRPN(tokens);
        System.out.println(res);
    }
}
