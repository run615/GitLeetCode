package Leetcode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class main105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]); // 1. 根据前序第一个节点确定根节点
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i)); // 2. 根据根节点在中序序列中的位置分割成左右两个子序列
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length)); // 3. 对左子树和右子树分别递归使用同样的方法继续分解
                break;
            }
        }
        return root;
    }
}
