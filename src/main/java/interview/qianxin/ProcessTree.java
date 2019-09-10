package interview.qianxin;

import java.util.*;

/**
 * 给定n个进程，这些进程满足以下条件：
 * 1 每个进程都有唯一的PID，其中PID为进程ID
 * 2 每个进程最多只有一个父进程，但可能有多个子进程，用PPID表示父进程ID
 * 3 若一个进程没有父进程，则其PPID为0
 * 4 PID，PPID都是无符号整数
 * 结束进程树的含义是结束一个进程时，它所有的子进程都会被结束
 * 结束进程时结束总的进程数量
 */
class TreeNode {
    int ob;
    List<TreeNode> treeNodes = new LinkedList<>();

    public TreeNode(int obj) {
        this.ob = obj;
    }
}

public class ProcessTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pid = scanner.nextLine();
        String ppid = scanner.nextLine();


        String[] pids = pid.split(" ");
        String[] ppids = ppid.split(" ");

        int[] pidData = new int[pids.length];
        int[] ppidData = new int[ppids.length];
        int k = scanner.nextInt();
        int sum = 0;


        for (int i = 0; i < pidData.length; i++) {
            pidData[i] = Integer.valueOf(pids[i]);
            ppidData[i] = Integer.valueOf(ppids[i]);
        }


        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < ppids.length; i++) {
            TreeNode treeNode;
            int val = ppidData[i];
            if (map.get(val) == null) {
                treeNode = new TreeNode(val);
                map.put(val, treeNode);
            } else {
                treeNode = map.get(val);
            }
            TreeNode child;
            int childVal = pidData[i];
            if (map.get(childVal) == null) {
                child = new TreeNode(childVal);
                map.put(childVal, child);
            } else {
                child = map.get(childVal);
            }
            treeNode.treeNodes.add(child);
        }

        TreeNode kNode = map.get(k);
        sum = breadthFirst(kNode);
        System.out.println(sum);
    }

    public static int breadthFirst(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> treeNodes = new LinkedList<>();

        int sum = 0;
        treeNodes.add(node);
        while (!treeNodes.isEmpty()) {
            node = treeNodes.pop();
            sum++;
            treeNodes.addAll(node.treeNodes);
        }
        return sum;
    }
}