package Leetcode;

import java.util.Stack;

/**
 * 71. 简化路径
 */
public class main71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            if (!stack.isEmpty() && split[i].equals("..")) {
                stack.pop();
            } else if (!split[i].equals("") && !split[i].equals(".") && !split[i].equals("..")) {
                stack.push(split[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/").append(stack.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        main71 p = new main71();
        String res = p.simplifyPath(new String(".."));
        System.out.println(res);
    }
}
