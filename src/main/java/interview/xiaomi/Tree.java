package interview.xiaomi;

import java.util.Scanner;



public class Tree {

    static int afterIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1= scanner.nextLine();
        String str2 = scanner.nextLine();

        char[] in = new char[str1.length()];
        char[] after = new char[str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            in[i] = str1.charAt(i);
            after[i] = str2.charAt(i);
        }

        int temp = after.length - 1;
        afterIndex = temp;
        int start = 0;
        int end = in.length - 1;
        TreeNode head = creatTree(start, end, in, after);
        preOrder(head);
    }

    public static class TreeNode {
        char val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode() {

        }
        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static TreeNode creatTree(int start, int end, char[] in, char[] after) {

        if(start > end) return null;
        char root = after[afterIndex];
        afterIndex--;
        int index = findIndex(in, root);
        TreeNode t = new TreeNode();
        t.val = root;
        if(start == end) {
            t.left = t.right = null;
        }
        else {
            t.right = creatTree(index + 1, end, in, after);
            t.left = creatTree(start, index - 1, in, after);
        }
        return t;
    }
    public static int findIndex(char[] a, int b) {
        int i = 0;
        for(i = 0; i < a.length; i++) {
            if(a[i] == b) {
                return i;
            }
        }
        return -1;
    }
    public static void preOrder(TreeNode head) {
        if(head == null) {
            return;
        }
        System.out.print(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

}