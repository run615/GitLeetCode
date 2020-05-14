package Leetcode;

import java.util.*;

/**
 * 面试0804  幂集
 */
public class mainmianshi0804 {
    /**
     * 思路：回溯
     */
    public List<List<Integer>> subsets(int[] nums) {
        //结果集合
        LinkedList<List<Integer>> list = new LinkedList<>();
        //回溯方法
        backtrack(list, new LinkedList<>(), nums, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, LinkedList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.removeLast();
        }
    }

    public static void main(String[] args) {
        mainmianshi0804 p = new mainmianshi0804();
        List<List<Integer>> res = p.subsets(new int[]{1, 2, 3});
        for (List list : res) {
            System.out.println(list);
        }
    }
}
