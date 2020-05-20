package Leetcode;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class main26 {
    /**
     * 数组相关的算法问题：要尽量避免在中间删除元素，想办法把这个元素换到最后去
     * 通用方式：双指针技巧，（快慢指针）
     * 让慢指针slow走在后面，快指针fast走在前面探路，找到不重复的元素就告诉slow并让slow前进一步。
     * 这样，当fast遍历完整个数组后，nums[0...slow]就是不重复的元素，之后的所有元素都是重复元素。
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护nums[0...slow]无重复元素
                nums[slow] = nums[fast];
            } else {
                fast++;
            }
        }
        // 长度为索引+1
        return slow + 1;
    }

    public static void main(String[] args) {
        main26 p = new main26();
        int res = p.removeDuplicates(new int[]{1,1,2,3,4,4,5});
        System.out.println(res);
    }
}
