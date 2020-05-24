package Leetcode;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class main518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                    // 你想⽤⾯值为 2 的硬币凑出⾦额 5，那么如果你知道了凑出⾦额3的⽅法，再加上⼀枚⾯额为2的硬币，不就可以凑出 5 了嘛。
                }else{ // 剩余的不足0元，就和前面一个状态一样
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }


}
