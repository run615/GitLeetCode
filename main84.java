package Leetcode;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class main84 {
    // 思路：一次遍历柱形的高度，对于每个高度分别向两边扩散，求出以当前高度为矩形的最大宽度是多少
    public int largestRectangleArea(int[] heights) {
        int maxSquare = 0;
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            // 找到左边最后一个大于等于height[i]的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找到右边最后一个大于等于height[i]的下标
            int right = i;
            while (right < len-1 && heights[right + 1] >= curHeight) {
                right++;
            }
            // 计算面积，长度是（right - left + 1）， 高度是curHeight
            maxSquare = Math.max(maxSquare, curHeight * (right - left + 1));
        }
        return maxSquare;
    }

    public static void main(String[] args) {
        main84 p = new main84();
        int[] height = {2, 1, 5, 6, 2, 3};
        int res = p.largestRectangleArea(height);
        System.out.println(res);
    }
}
