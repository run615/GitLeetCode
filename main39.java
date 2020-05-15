package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取，但是解集不能包含重复的组合。
 */
public class main39 {
    LinkedList<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates); // 听说排序之后在回溯的时候方便剪枝
        backtrack(candidates, 0, target, track);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target, LinkedList<Integer> trace) {

        // 结束条件
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new LinkedList<>(trace));
        }

        // 选择路径
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) { // 排序的好处在这里，可以直接剪枝，否则还得遍历
                break;
            }
            trace.offer(candidates[i]);
            backtrack(candidates, i,target - candidates[i], trace);
            // 回溯
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        main39 p = new main39();
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> res = p.combinationSum(candidates, 7);
        for (List list : res) {
            System.out.println(list);
        }
    }
}
