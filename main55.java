package Leetcode;

/**
 * 55. 跳跃游戏
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class main55 {
    /**
     * dp问题一般是用来求最值
     * 这题可以修改一下题意，改成通过题目中的跳跃规则，最多能跳多远？如果能够跳跃超过最后一格，返回ture，否则返回false。
     * 这就是贪心算法，每一步都计算一下从当前位置最远能够跳到哪里，然后和一个全局最优的最原位置farthest做对比，通过每一步的最优解，更新全局最优解。
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能够跳到的最远距离
            farthest = Math.max(farthest, nums[i] + i);
            // 可能碰到0，卡住跳不动了, 比如「3 2 1 0 4」
            if (farthest <= i) { // farthest = 3; i = 3; 跳不出去了
                return false;
            }
        }
        return farthest >= n - 1; // 看看最后能不能够跳跃超过最后一格
    }

    /**
     * 复杂度分析:
     * 时间复杂度：O(n)，其中 n 为数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
     * 空间复杂度：O(1)，只需要开辟一个arriveMost数组，不需要额外的空间开销。
     */
    public static void main(String[] args) {
        main55 p = new main55();
        Boolean res = p.canJump(new int[]{2, 3, 1, 1, 4});
        //Boolean res = p.canJump(new int[]{3, 2, 1, 0, 4});
        if (res) {
            System.out.println("可以完成跳跃");
        } else {
            System.out.println("永远不会成功");
        }
    }
}
