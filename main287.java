package Leetcode;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class main287 {
    /**
     * HashSet判重
     * @param args
     */
    //public int findDuplicae(int[] nums) {
    //    HashSet table = new HashSet();
    //    for(Integer num : nums){
    //        if(!table.add(num)){
    //            return num;
    //        }
    //    }
    //    return 0;
    //}

    /**
     * 二分法
     * 区间 [1, 7]的中位数是 4，遍历整个数组，统计小于等于 4 的整数的个数，最多为 44 个，等于 44 的时候也可能有重复。
     * 但是，如果整个数组里小于等于 4 的整数的个数如果严格大于 44 个，就说明重复的数存在于区间 [1, 4][1,4]。
     *
     */
    //public int findDuplicae(int[] nums) {
    //    int len = nums.length;
    //    int left = 1;
    //    int right = len - 1;
    //    while (left < right) {
    //        // 在java里可以这么用,在left+right 溢出的时候，无符号右移保证结果依然正确
    //        int mid = (left + right) >>> 1;
    //        int cnt = 0;
    //        for (int num : nums) {
    //            if (num <= mid) {
    //                cnt += 1;
    //            }
    //        }
    //
    //        //根据抽屉原理，小于等于mid的个数如果严格大于中间数，此时重复元素一定是在前半区间里
    //        if (cnt > mid) {
    //            // 重复元素位于[left, mid]
    //            right = mid;
    //        } else {
    //            //if 分析正确后，else 搜索的区间就是if的反面，[mid+1, right]
    //            left = mid + 1;
    //        }
    //    }
    //    return left;
    //}

    /**
     * 快慢指针法
     * 利用寻找链表的入环节点的思想, 把数组当成对链表的一种描述, 数组里的每一个元素的值表示链表的下一个节点的索引
     */
    public int findDuplicae(int[] nums) {
        int slow = nums[0]; // 1
        int fast = nums[slow]; // 3
        while (slow != fast) {
            slow = nums[slow]; //3 // 2
            fast = nums[nums[fast]];  // 2 // 2
        } // 循环结束后已经找到了相遇节点
        slow =  0; // 将慢指针指回原点
        while (slow != fast) {
            slow = nums[slow]; // 1 // 2
            fast = nums[fast]; // 4 // 2
        } // 最后相遇就是环口，也就是答案
        return slow;
    }

    public static void main(String[] args) {
        main287 p = new main287();
        int res = p.findDuplicae(new int[]{1, 3, 4, 2, 2});
        System.out.println(res);
    }
}
