package Leetcode;

import java.util.Arrays;

public class main560 {
    /**
     * 暴力法（超时）
     */
    //public int subarraySum(int[] nums, int k) {
    //    int len = nums.length;
    //    int count = 0;
    //    for (int left = 0; left < len; left++) {
    //        for (int right = left; right < len; right++) {
    //            int sum = 0;
    //            for (int i = left; i <= right; i++) {
    //                sum += nums[i];
    //            }
    //            if (sum == k) {
    //                count++;
    //            }
    //        }
    //    }
    //    return count;
    //}

    /**
     * 优化暴力法
     * 固定了起点，时间复杂度下降一维
     */
    //public int subarraySum(int[] nums, int k) {
    //    int count = 0;
    //    int len = nums.length;
    //    for (int left = 0; left < len; left++) {
    //        int sum = 0;
    //        for (int right = left; right < len; right++) {
    //            sum += nums[right];
    //            if (sum == k) {
    //                count++;
    //            }
    //        }
    //    }
    //    return count;
    //}

    /**
     * 前缀和
     * 构建前缀和数组，以快速计算区间, 类似于dp，但有区别。这里需要根据差值为target来找答案
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] = nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        main560 p = new main560();
        int[] nums = new int[]{-1, -1, 2, -2};
        int res = p.subarraySum(nums, 0);
        System.out.println(res);
        //  1 2 1 3 2 2   (4)
        //0 1 3 4 7 9 11
    }
}
