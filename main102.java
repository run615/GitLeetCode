package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class main102 {
    /**
     * 思路：BFS
     */
    //public List<List<Integer>> levelOrder(TreeNode root) {
    //    List<List<Integer>> result = new LinkedList<>();
    //    if (root == null) {
    //        return result;
    //    }
    //    Queue<TreeNode> q = new LinkedList<>();
    //    q.offer(root); // 添加起点
    //
    //    while (!q.isEmpty()) {
    //        int curSize = q.size(); // 实时更新当前队列长度
    //        LinkedList<Integer> subList = new LinkedList<>();
    //        for (int i = 0; i < curSize; i++) {
    //            TreeNode curr = q.poll();
    //            if (curr != null) {
    //                subList.add(curr.val);
    //                if (curr.left != null) {
    //                    q.offer(curr.left);
    //                }
    //                if (curr.right != null) {
    //                    q.offer(curr.right);
    //                }
    //            }
    //        }
    //        result.add(subList);
    //    }
    //    return result;
    //}

    /**
     * 思路：DFS
     * 1. 把二叉树摆成田字形，田字形的每一层对应一个list
     *    1
     *    2  5
     *    3  4  6
     *    这样先访问1，再访问2，接着3，然后4，然后5，最后6
     *
     *  2. 用res.get(level-1).add(val),可以在当前层的list里继续添加新值。
     *
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(1, root, res);
        return res;
    }

    private void dfs(int level, TreeNode curRoot, ArrayList<List<Integer>> res) {
        if (res.size() < level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level - 1).add(curRoot.val);
        if (curRoot.left != null) {
            dfs(level + 1, curRoot.left, res);
        }
        if (curRoot.right != null) {
            dfs(level + 1, curRoot.right, res);
        }
    }

}
