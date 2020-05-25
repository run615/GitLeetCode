package Leetcode;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class main416 {
    /**
     * 可以将此问题转化成背包问题
     * 给⼀个可装载重量为 「sum / 2 」的背包和 N 个物品，每个物品的重量为nums[i] 。现在让你装物品，是否存在⼀种装法，能够恰好将背包装满？
     */
    public boolean canPartition(int[] nums) {
        // 1. 状态定义：
        // dp[i][j] = x 表示对于前i个物品，当前背包的容量为j时，若x为true，则说明可以恰好将背包装满，若x为false，则表示不能恰好将背包装满
        // 如果 dp[4][9] = true ，其含义为：对于容量为 9 的背包，若只是⽤前 4 个物品，可以有⼀种⽅法把背包恰好装满。
        // 对于本题对于给定的集合中，若只对前 4 个数字进⾏选择，存在⼀个⼦集的和可以恰好凑出 9。
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case: 因为当背包没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包。
        // 所以dp[i][0] = true; dp[0][i] = false;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j]; // // 不把nums[i]算入子集，或者说不把第i个物品装入背包，是否能够装满背包，取决于上一个状态dp[i - 1][j]
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        main416 p = new main416();
        boolean res = p.canPartition(new int[]{1, 2, 3, 6});
        if (res) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
