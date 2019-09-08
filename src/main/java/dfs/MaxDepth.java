package dfs;

/**
 * leetcode 104 简单
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left_depth=maxDepth(root.left);
        int right_depth=maxDepth(root.right);
        return Math.max(left_depth,right_depth)+1;
    }
}
