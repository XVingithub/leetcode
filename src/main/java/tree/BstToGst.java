package tree;



/**
 * leetcode 1038 中等
 * 给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键小于节点键的节点。
 * 节点的右子树仅包含键大于节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class BstToGst {

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    int sum = 0;// 记录每个节点的右边的所有节点和，即原树中大于 node.val 的值之和
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);// 先访问所有大于root的节点
        root.val += sum;// 赋值给当前节点
        sum = root.val;// 保存更大和
        dfs(root.left);// 后访问小于root的节点
    }

}
