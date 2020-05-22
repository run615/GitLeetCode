package Leetcode;

/**
 * 392. 判断子序列
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 */
public class main392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    


    public static void main(String[] args) {
        main392 p = new main392();
        boolean res = p.isSubsequence(new String("axc"), new String("ahbgdc"));
        if (res) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }
}
