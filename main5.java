package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 5. 最长回文字段
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */

public class main5 {
    /**
     * dp
     * 1. dp[i]: 以i为结尾的最长回文子串
     * 2. 状态转移方程: dp[i] = dp[i-1] + 2 ;(if nums[i] == nums[i-1 - dp[i-1]])
     * 3. 初始化: Arrays.fill(dp,1);
     * 4. 输出: Math.max(dp[i])
     */
    //public String longestPalindrome(String s) {
    //    int len = s.length();
    //    if (len < 2) {
    //        return s;
    //    }
    //    boolean[][] dp = new boolean[len][len];
    //
    //    // 初始化
    //    for (int i = 0; i < len; i++) {
    //        dp[i][i] = true;
    //    }
    //    int maxLen = 1;
    //    int start = 0;
    //
    //    for (int j = 1; j < len; j++) {
    //        for (int i = 0; i < len; i++) {
    //            if (s.charAt(i) == s.charAt(j)) {
    //                if (j - i < 3) { // 边界条件：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3
    //                    dp[i][j] = true;
    //                } else {
    //                    dp[i][j] = dp[i + 1][j - 1];
    //                }
    //            } else {
    //                dp[i][j] = false;
    //            }
    //            // 只要一得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，因为截取字符串也要消耗性能，记录此时的回文子串的“起始位置”和“回文长度”即可。
    //            if (dp[i][j]) {
    //                int curLen = j - i + 1;
    //                if (curLen > maxLen) {
    //                    maxLen = curLen;
    //                    start = i;
    //                }
    //            }
    //        }
    //    }
    //    return s.substring(start, start + maxLen);
    //}


    /**
     * 暴力法： 但是会TLE
     * 时间复杂度: O(n^3)
     * 空间复杂度: O(1)
     */
    //public boolean isPalindrome(String s) {
    //    for (int i = 0; i < s.length() / 2; i++) {
    //        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
    //            return false;
    //        }
    //    }
    //    return true;
    //}
    //
    //public String longestPalindrome(String s) {
    //    String ans = "";
    //    int longest = 0;
    //    for (int i = 0; i < s.length(); i++) {
    //        for (int j = i + 1; j <= s.length(); j++) {
    //            String test = s.substring(i, j);
    //            if (isPalindrome(test) && test.length() > longest) {
    //                ans = s.substring(i, j);
    //                longest = Math.max(longest, ans.length());
    //            }
    //        }
    //    }
    //    return ans;
    //}

    /**
     * 中心扩散法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0, right = 0, longest = 0;
        int len = 1; // 用来防止只有一位字符的情况
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                len += 2;
                left--;
                right++;
            }
            if (len > longest) {
                longest = len;
                maxStart = left;
            }
            len = 1; // 每轮循环结束后，重置len值。
        }

        return s.substring(maxStart + 1, maxStart + longest + 1);
    }

    public static void main(String[] args) {
        main5 p = new main5();
        String res = p.longestPalindrome("babad");
        System.out.println(res);
    }
}
