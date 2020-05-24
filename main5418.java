package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main5418 {
    /**
     * dfs+ 回溯
     */
    List<List<Integer>> re = new ArrayList<>();  // re存放的是所有路径，这些路径将要进行做分析是否是回文的
    LinkedList<Integer> list = new LinkedList<Integer>();
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int count = 0;
        dfs(root);  // 得到所有的路径，保存在list里，使用dfs，当遍历的节点的左右子节点都为空了，那么就是一条从头节点到叶子节点的路径。

        for (List<Integer> temp : re) {
            if (check(temp)) {
                count++;
            }
        }
        return count;
    }

    // 判断路径是否是回文的
    private boolean check(List<Integer> temp) {
        int[] t = new int[10];  // 先创建0-9 十个位置
        for (int i = 0; i < temp.size(); i++) {
            t[temp.get(i)]++;
        }
        int even = 0; // 统计路径中出现的数字的次数，当有两个或者两个以上的次数为奇数，就不是回文的
        for (int i = 0; i < 10; i++) {
            if (t[i] % 2 == 1) {
                even++;
            }
        }
        return even < 2;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            re.add(new ArrayList<>(list)); // 当遍历的节点的左右子节点都为空了，那么就是一条从头节点到叶子节点的路径。
            list.removeLast(); // 需要回溯，去掉上一次添加的节点值
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
        list.removeLast();
    }
}
