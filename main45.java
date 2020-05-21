package Leetcode;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class main45 {
    /**
     * 现在的问题是，保证可以跳到最后一格，请问最少要跳几次，才能跳过去？
     * 所以用贪心选择性质，不需要递归的计算出所有每个点的所有选择的具体结果然后比较最值，而是只需要做出那个最有潜力（能跳的最远的选择）
     */
    public int jump(int[] nums) {
        int end = 0;  // 标记了可以选择的跳跃步数
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition,nums[i]+i); // maxPosition标记了所有选择[i...end]中能够跳到的最远距离
            if (i == end) {
                end = maxPosition;
                steps++;  // 记录了跳跃次数
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        main45 p = new main45();
        int res = p.jump(new int[]{2, 3, 1, 1, 4, 2, 1});
        System.out.println(res);
    }
}
