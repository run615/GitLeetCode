package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class main22 {
    /**
     * 思路：递归
     */
    //ArrayList<String> list = new ArrayList<>();
    //public List<String> generateParenthesis(int n) {
    //    if (n == 0) {
    //        return new ArrayList<>();
    //    }
    //    // 这里 dp 数组我们把它变成列表的样子，方便调用而已
    //    List<List<String>> dp = new ArrayList<>(n);
    //
    //    List<String> dp0 = new ArrayList<>();
    //    dp0.add("");
    //    dp.add(dp0);
    //
    //    for (int i = 1; i <= n; i++) {
    //        List<String> cur = new ArrayList<>();
    //        for (int j = 0; j < i; j++) {
    //            List<String> str1 = dp.get(j);
    //            List<String> str2 = dp.get(i - 1 - j);
    //            for (String s1 : str1) {
    //                for (String s2 : str2) {
    //                    // 枚举右括号的位置
    //                    cur.add("(" + s1 + ")" + s2);
    //                }
    //            }
    //        }
    //        dp.add(cur);
    //    }
    //    return dp.get(n);
    //}
    /**
     * dfs
     */
    //List<String> res = new ArrayList<>();
    //public List<String> generateParenthesis(int n) {
    //    dfs(n, n, "");
    //    return res;
    //}
    //
    //private void dfs(int left, int right, String curStr) {
    //    if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
    //        res.add(curStr);
    //        return;
    //    }
    //
    //    if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
    //        dfs(left - 1, right, curStr + "(");
    //    }
    //    if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
    //        dfs(left, right - 1, curStr + ")");
    //    }
    //
    //}

    /**
     * 回溯
     *         // 选择列表：两个括号'(' ')'
     *         // 结束条件：当长度为6的时候
     *         // 注意：选出来的括号组合要合法，组合是从左往右生成的，即左括号的数量都大于或者等于右括号的数量
     *         // 所以使用两个变量left,right：分别记录以及生成的左括号数量和右括号数量
     */
    List<String> result = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        // 左括号与右括号的数量初始化为n，每次生成一个括号则数量-1
        backtrack(n, n, new StringBuilder());
        return result;
    }

    private void backtrack(int left, int right, StringBuilder trace) {
        // 如果右括号的数量大于左括号的数量，那就不符合条件直接返回； （剩余右括号必须大于剩余左括号）
        if (right < left) {
            return;
        }
        // 如果剩余左括号或者剩余右括号的数量小于0，也不符合要求；
        if (left < 0 || right < 0) {
            return;
        }
        // 都正好用完了，表示可以了；
        if (left == 0 && right == 0) {
            result.add((trace.toString()));
            return;
        }
        // 做出选择'('
        trace.append("(");
        backtrack(left - 1, right, trace);
        // 撤销选择')'
        trace.deleteCharAt(trace.length() - 1);

        // 做出选择')'
        trace.append(")");
        backtrack(left, right - 1, trace);
        // 撤销选择')'
        trace.deleteCharAt(trace.length() - 1);
    }

    public static void main(String[] args) {
        main22 p = new main22();
        List<String> res = p.generateParenthesis(3);
        System.out.println(res);
    }
}
