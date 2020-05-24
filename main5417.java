package Leetcode;

/**
 * 5417. 定长子串中元音的最大数目
 */

public class main5417 {
    /**
     * 长度为k的窗口，双指针
     */
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i = 0;
        int count = 0, result = 0;

        // 双指针
        for (int j = 0; j < n; j++) {
            if ("aeiou".indexOf(String.valueOf(s.charAt(j))) != -1) {
                count++;
            }
            if (j > k - 1) {  // 当j遍历超过k长度时，开始滑动窗口
                if ("aeiou".indexOf(String.valueOf(s.charAt(i))) != -1) { // 如果当前这个字符出现在"aeiou"里，因为要舍弃掉最左边的字符，所以count也要减去一位。
                    count--;
                }
                i++;  // 滑动窗口，左指针向右走
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        main5417 p = new main5417();
        String s = new String("weallloveyou");
        int k = 7;
        int res = p.maxVowels(s, k);
        System.out.println(res);
    }
}
