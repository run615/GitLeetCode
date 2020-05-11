package Leetcode;

import java.util.HashMap;

/**
 * 1. 两数之和
 *
 */
public class main1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put( nums[i],i);
        }
        for (int i = 0; i < map.size(); i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) &&  map.get(tmp) != i) {
                return new int[]{nums[i],tmp};
            }
        }
        throw new IllegalArgumentException("没有正确答案");
    }

    public static void main(String[] args) {
        main1 p = new main1();
        int[] res = p.twoSum(new int[]{2, 7,7, 11, 15}, 14);
        System.out.println(res);
    }
}

//时间复杂度：O(n)
// 我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
// 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1 ; i++){
            for(int j = i + 1; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}



// 时间复杂度：O(n^2)
// 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)的时间。
// 因此时间复杂度为 O(n^2)。
// 空间复杂度：O(1)
