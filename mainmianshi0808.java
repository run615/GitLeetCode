package Leetcode;

import java.util.HashSet;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 */
public class mainmianshi0808 {
    // 全排列问题
    public String[] permutation(String S) {
        HashSet<String> res = new HashSet<>();
        backtrack(res, S, new StringBuilder(), new boolean[S.length()]);
        return res.toArray(new String[res.size()]);
    }

    private void backtrack(HashSet<String> res, String s,StringBuilder trace, boolean[] marked) {
        if (trace.length() == s.length()) {
            res.add(trace.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                trace.append(s.charAt(i));
                backtrack(res, s, trace, marked);
                trace.deleteCharAt(trace.length() - 1);
                marked[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        mainmianshi0808 p = new mainmianshi0808();
        String[] res = p.permutation(new String("qqe"));
        for (String s : res) {
            System.out.println(s);
        }
    }
}
