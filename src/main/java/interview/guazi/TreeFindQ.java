package interview.guazi;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * 中序遍历二叉树时查找目标节点的前一个节点
 */
class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x){
        this.val=x;
    }

}
public class TreeFindQ {
    static TreeNode pre=null;
    public static TreeNode createTree(TreeNode root,int index,int[] arr){
        if(index>=arr.length){
            return null;
        }
        if(arr[index]==-1){
            return null;
        }
        root=new TreeNode(arr[index]);
        root.left=createTree(root.left,2*index+1,arr);
        root.right=createTree(root.right,2*index+2,arr);
        return root;
    }

    //查找中序遍历目标节点的前序节点
    public static void findQ(TreeNode root,TreeNode q){
        if(root==null){
            return;
        }
        findQ(root.left,q);
        if(q.val==root.val){
            if(pre==null){
                System.out.println("中序遍历的前序节点为空");
            }else {
                System.out.println("findQ:"+pre.val);
            }
            return;
        }else {
            pre=root;
        }
        findQ(root.right,q);
    }

    public static void DFS(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode node1=stack.pop();
            System.out.println(node1.val);
            if(node1.right!=null){
                stack.push(node1.right);
            }
            if(node1.left!=null){
                stack.push(node1.left);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        TreeNode root=new TreeNode(-1);
        root=createTree(root,0,arr);
        DFS(root);
        findQ(root,new TreeNode(1));
    }
}
