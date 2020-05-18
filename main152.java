package Leetcode;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class main152 {
    /**
     * 动态规划思想：
     * 	1. 状态设计：
     * 		由于最大值和最小值是相互转换的，所以需要在原始的状态设计后面多加一个维度
     * 		dp[i][j]：以nums[i]结尾的连续子数组的最值，计算最大值还是最小值由j来表示；
     * 			○ 当 j = 0; 表示计算的是最小值；
     * 			○ 当 j = 1; 表示计算的是最大值；
     * 	2. 状态转移方程：
     * 		○ 当 nums[i] > 0 时：
     * 			w 最大值乘以正数依然是最大值；
     * 			w 最小值乘完依然是最小值；
     * 		○ 当 num[i] < 0 时：
     * 			w 最大值乘以负数变成了最小值；
     * 			w 最小值乘完变成最大值；
     * 		○ 当 nums[i] = 0 的时候，由于nums[i]必须被选取，最大值和最小值都变成0，合并到上面任意一种情况均成立。
     * 		○ 但是，之前状态值的正负也要考虑，必须，在考虑最大值的时候，当 nums[i] > 0的时候，如果 dp[i-1][1] < 0，此时 nums[i] 可以另起炉灶，dp[i][1] = nums[i] , 即 dp[i][1] = max.(nums[i] , nums[i] * dp[i-1][1] if(nums[i] >= 0
     * 	3. 考虑初始化：
     * 		由于nums[i] 必须被选取，所以dp[i][0] = nums[0] = dp[i][1]
     * 	4. 考虑输出：
     *      要求的是连续子数组的乘积最大值，遍历dp[i][1]
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最大值
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }

        // 只关心最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        main152 p = new main152();
        int res = p.maxProduct(new int[]{-2,0,-1});
        System.out.println(res);
    }
}

//nums     3, -1, 4
//dp[i]    1,  3, -3, -12
//max          3, 3,  3
