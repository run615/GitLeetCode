package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76.最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 */
public class main76 {
    /**
     * 动态规划
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : s.toCharArray()) lookup.put(c, 0);
        for (char c : t.toCharArray()) {
            if (lookup.containsKey(c)) lookup.put(c, lookup.get(c) + 1);
            else return "";
        }
        int start = 0;
        int end = 0;
        int min_len = Integer.MAX_VALUE;
        int counter = t.length();
        String res = "";
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (lookup.get(c1) > 0) counter--;
            lookup.put(c1, lookup.get(c1) - 1);
            end++;
            while (counter == 0) {
                if (min_len > end - start) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                char c2 = s.charAt(start);
                if (lookup.get(c2) == 0) counter++;
                lookup.put(c2, lookup.get(c2) + 1);
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        main76 p = new main76();
        String res = p.minWindow(new String("ADOBECODEBANC"), new String("ABC"));
        System.out.println(res);
    }
}
