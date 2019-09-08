package dfs;

import java.util.LinkedList;

/**
 * leetcode 98 DFS
 */
public class IsVslidBSTDFS {
    LinkedList<TreeNode> stack=new LinkedList<>();
    LinkedList<Integer> lowers=new LinkedList<>();
    LinkedList<Integer> uppers=new LinkedList<>();
    public void update(TreeNode root,Integer lower,Integer upper){
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }
    public boolean isValidBST(TreeNode root) {
        Integer lower=null,upper=null,val;
        update(root,lower,upper);
        while (!stack.isEmpty()){
            root=stack.poll();
            lower=lowers.poll();
            upper=uppers.poll();
            if(root==null){
                continue;
            }
            val=root.val;
            if(upper!=null&&val>=upper){
                return false;
            }
            if (lower!=null&&lower>=val){
                return false;
            }
            update(root.right,val,upper);
            update(root.left,lower,val);
        }
        return true;
    }
}
