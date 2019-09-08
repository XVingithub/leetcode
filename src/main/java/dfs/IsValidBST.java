package dfs;

/**
 *
 * leetcode 98 中等
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode node,Integer lower,Integer upper){
        if (node==null){
            return true;
        }
        if(lower!=null&&lower>=node.val){
            return false;
        }
        if (upper!=null&&upper<=node.val){
            return false;
        }
        if(!helper(node.right,node.val,upper)){
            return false;
        }
        if(!helper(node.left,lower,node.val)){
            return false;
        }
        return true;
    }
}
