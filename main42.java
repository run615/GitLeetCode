package Leetcode;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class main42 {
    /**
     * 暴力法：每格能装的水 = min（左边最高的柱子 - 右边最高的柱子）- 当前格子的高度
     */
    //public int trap(int[] height) {
    //    int len = height.length;
    //    int ans = 0;
    //    for (int i = 1; i < len - 1; i++) {
    //        int l_max = 0, r_max = 0;
    //        // 找到右边最高的柱子
    //        for (int j = i; j < len; j++) {
    //            r_max = Math.max(r_max, height[j]);
    //        }
    //        // 找左边最高的柱子
    //        for (int j = i; j >= 0; j--) {
    //            l_max = Math.max(l_max, height[j]);
    //        }
    //        ans += Math.min(l_max, r_max) - height[i];
    //    }
    //    return  ans;
    //}

    /**
     * 备忘录优化,主要是为了避免重复计算
     * 开两个数组r_max 和 l_max 充当备忘录：
     * l_max[i] 表⽰位置 i 左边最⾼的柱⼦⾼度， r_max[i] 表⽰位置 i 右边最⾼的柱⼦⾼度。
     * 预先把这两个数组计算好，避免重复计算
     */
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int len = height.length;
        int ans = 0;
        // 数组充当备忘录
        int[] l_max = new int[len];
        int[] r_max = new int[len];
        // 初始化base case
        l_max[0] = height[0];
        r_max[len - 1] = height[len - 1];
        // 从左向右计算l_max
        for (int i = 1; i < len; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        // 从右向左计算r_max
        for (int i = len - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        // 计算答案
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        main42 p = new main42();
        int res = p.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(res);
    }
}
