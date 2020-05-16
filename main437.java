package Leetcode;

/**
 * 437. 路径总和 III
 */
public class main437 {
    // 用递归
    public int pathSum(TreeNode root, int sum) { // 返回以这个节点为根的树中，和为目标值的路径总和
        if(root == null){
            return 0;
        }
        int pathImLeading = count(root,sum); // 自己为开头的路径数
        int leftPathSum = pathSum(root.left, sum); // 左边路径总数（相信他能算出来)
        int rightPathSum = pathSum(root.right, sum);
        return pathImLeading + leftPathSum + rightPathSum ;
    }
    private int count(TreeNode node, int sum){ // 返回以这个节点为根的树中，能凑出几个以该节点为「路径开头」，和为目标值的路径总和
        if(node == null){
            return 0;
        }
        int isMe = (node.val == sum) ? 1 : 0; // 判断自己能不能独当一面，作为一条路径；
        int leftBrother = count(node.left, sum - node.val); // 我左边的小老弟，如果以我为开头，你那里能凑出来几组『sum - node.val』值
        int rightBrother = count(node.right, sum - node.val); // 我右边的小老弟，如果以我为开头，你那里能凑出来几组『sum - node.val』值
        return isMe + leftBrother + rightBrother;
    }
}
