package Leetcode;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class main238 {
    /**
     *  时间复杂度不符合的方法
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            int indexValue = 1;
            while (index < nums.length) {
                if (index == i) {
                    index++;
                } else {
                    indexValue *= nums[index];
                    index++;
                }
            }
            result[i] = indexValue;
        }
        return result;
    }

    /**
     * 前缀 * 后缀
     */
    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        a[0] = 1;
        b[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            a[i] = nums[i - 1] * a[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            b[i] = nums[i + 1] * b[i + 1];
        }
        for(int i = 0; i < nums.length ; i++){
            a[i] = a[i] * b[i];
        }
        return a;
    }

    public static void main(String[] args) {
        main238 p = new main238();
        int[] nums = {1, 2, 3, 4};
        int[] res = p.productExceptSelf(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
