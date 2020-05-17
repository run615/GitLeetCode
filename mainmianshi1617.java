package Leetcode;

/**
 * 面试题 16.17. 连续数列
 */
public class mainmianshi1617 {
    /**
     * 动态规划法
     */
    //public int maxSubArray(int[] nums) {
    //    int sum = 0;
    //    int max = nums[0];
    //    for (int num : nums) {
    //        if (sum <= 0) {
    //            sum = num;
    //        } else {
    //            sum = sum + num;
    //        }
    //        max = Math.max(max, sum);
    //    }
    //    return max;
    //}
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArray(nums, 0, len - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return mid;
    }


    public static void main(String[] args) {
        mainmianshi1617 p = new mainmianshi1617();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = p.maxSubArray(nums);
        System.out.println(res);
    }
}
