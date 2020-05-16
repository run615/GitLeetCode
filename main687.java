package Leetcode;

/**
 * 687. 最长同值路径
 */
public class main687 {
    int maxCount; // 记录最长路径

    public int longestUnivaluePath(TreeNode root) {
        if ((root == null) || (root.left == null && root.right == null)) {
            return 0;
        }
        // 以根节点自己为起点的路径，最长长度是多少
        int pathImLeading = count(root);
        return maxCount;
    }

    // 以node为根（不考虑父节点）且包含node本身所在的单侧“最长“同值路径的长度
    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left);
        int right = count(node.right);
        int countLeft = 0, countRight = 0;
        if (node.left != null && node.left.val == node.val) {
            countLeft = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            countRight = right + 1;
        }
        maxCount = Math.max(maxCount, countLeft + countRight);
        return Math.max(countLeft, countRight);
    }

    public static void main(String[] args) {
        main687 p = new main687();
        TreeNode root = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = null;
        t3.left = t6;
        int res = p.longestUnivaluePath(root);
        System.out.println(res);
    }
}
