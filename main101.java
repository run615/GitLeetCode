package Leetcode;

/**
 * 101. 对称的二叉树
 */
public class main101 {
    public boolean isSymmetric(TreeNode root) {
        return judge(root, root);
    }

    private boolean judge(TreeNode ltree, TreeNode rtree) {
        if (ltree == null && rtree == null) {
            return true;
        }
        if (ltree == null || rtree == null) {
            return false;
        }
        return (ltree.val == rtree.val) && judge(ltree.left, rtree.right) && judge(ltree.right, rtree.left);
    }

    public static void main(String[] args) {
        main101 p = new main101();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        boolean res = p.isSymmetric(t1);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

