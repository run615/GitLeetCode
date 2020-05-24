package Leetcode;

/**
 * 5419. 两个子序列的最大点积
 * 给你两个数组 nums1 和 nums2 。
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 */
public class main5419 {
    /**
     * dp问题：
     * 1. 状态定义：dp[i][j]的含义是到nums1[i]和nums2[j]为止的子序列的最大点积
     * 2. 状态转移方程：
     *      1. 选择nums1[i]和nums2[j]
     *          1.1 不选择前面的 dp[i][j]=nums1[i]*nums2[j]
     *          1.2 也选择前面的 dp[i][j]=max(dp[i][j],nums1[i]*nums2[j]+dp[i-1][j-1])
     *              因为dp[i][j]是截止到nums1[i]和nums2[j]中的最大点积，所以只需要dp[i-1][j-1]就可以了
     *              事实上从这里可以看出想法一就是想法二的情况之一
     *
     *      2. 选择nums1[i],不选择nums2[j]
     *         等价于dp[i][j-1]
     *         dp[i][j]=max(dp[i][j],dp[i][j-1])
     *
     *      3. 不选择nums1[i],选择nums2[j]
     *         等价于dp[i-1][j]
     *         dp[i][j]=max(dp[i][j],dp[i-1][j])
     *
     *      4. 两个都不选择
     *         dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]);
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int M=nums1.length, N=nums2.length;
        int[][] dp=new int[M+1][N+1];
        for (int i=0; i<M+1; i++){
            for (int j=0; j<N+1; j++){
                dp[i][j]=-100001;
            }
        }

        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                // 两个数都用
                dp[i][j]=nums1[i-1]*nums2[j-1];
                dp[i][j]=Math.max(dp[i][j], dp[i][j]+dp[i-1][j-1]);
                // 只用一个数
                dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j]=Math.max(dp[i][j], dp[i][j-1]);
                // 都不用
                dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]);
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        main5419 p = new main5419();
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};
        int res = p.maxDotProduct(nums1, nums2);
        System.out.println(res);
    }

}
