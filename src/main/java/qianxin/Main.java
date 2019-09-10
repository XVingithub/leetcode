package qianxin;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 输入二叉查找树，查找两个节点的最近公共祖先。
 */
class TreeNode1 {

    TreeNode1 left;
    TreeNode1 right;
    int val;
    TreeNode1(int x){
        this.val=x;
    }

}
public class Main {
    public static TreeNode1 createNode(TreeNode1 rot,int index,int[] a) {
        if(index>= a.length ) {
            return null;
        }
        if(a[index]==-1) {
            return null;
        }
        rot=new TreeNode1(a[index]);
        rot.left=createNode(rot.left,2*index+1,a);
        rot.right=createNode(rot.right,2*index+2,a);
        return rot;
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int n=1<<x;
        n=n-1;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        TreeNode1 head=new TreeNode1(-1);


        head=createNode(head,0,a);
        int left=scanner.nextInt();
        int right=scanner.nextInt();
        TreeNode1 res=getFather(head,left,right);
        System.out.println(res.val);
    }



    public static TreeNode1 getFather(TreeNode1 root,int x,int y){
        if(root==null)
            return null;
        if(root.val==x||root.val==y)
            return root;
        TreeNode1 left=getFather(root.left,x,y);
        TreeNode1 right=getFather(root.right,x,y);
        if(left!=null&&right!=null)
            return root;
        if(left!=null){
            return left;
        }else {
            return right;
        }
    }

}