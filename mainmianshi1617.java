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

    /**
     * 分治法
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    // 利用二分法来划分子区间
    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return max3(maxSubArraySum(nums, left, mid), maxSubArraySum(nums, mid + 1, right), maxCrossingSum(nums, left, mid, right));
    }

    // 计算包含子区间[mid,mid+1]的子区间，即nums[mid] 和nums[mid+1]一定会被选取
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    // 计算三个部分的最大值）
    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }


    public static void main(String[] args) {
        mainmianshi1617 p = new mainmianshi1617();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = p.maxSubArray(nums);
        System.out.println(res);
    }
    
}
