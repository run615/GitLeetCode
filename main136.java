package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 136. 只出现一次的数字
 */
public class main136 {
    /**
     * 思路：按位异或^，因为异或满足交换律，所以不需要先排序了！
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for(int i = 1; i < nums.length; i++)
                ans = ans ^ nums[i];
        }
        return ans;
    }

    /**
     * Hash表
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            int cnt = map.get(i);
            if (cnt == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        main136 p = new main136();
        int res = p.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(res);
    }
}
