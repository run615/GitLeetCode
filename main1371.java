package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 */
public class main1371 {
    /**
     * 前缀和 + 状态压缩
     *
     * 1. 利用两个前缀和的差值，得到某个字母的出现次数，要对每个元音字母维护一个前缀和，定义 \textit{pre}[i][k]pre[i][k] 表示在字符串前 ii 个字符中，第 kk 个元音字母一共出现的次数。
     *    假设我们需要求出 [l,r][l,r] 这个区间的子串是否满足条件，那么我们可以用 pre[r][k]-pre[l-1][k]pre[r][k]−pre[l−1][k]，
     *
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }

            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            }else{
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        main1371 p = new main1371();
        int res = p.findTheLongestSubstring(new String("eleetminicoworoep"));
        System.out.println(res);
    }
}
