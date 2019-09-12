package interview.xueersi;

import java.util.Scanner;

public class ReverseDoubleTraceNode {
    private String[] strings;

    static class Node{
        int sno;
        Node pre;
        Node next;
        public Node(int no){
            sno=no;
        }
    }

    public static void main(String[] args) {
        Node node=new Node(-1);
        Node p=node;
        Node tail=p;
        Scanner scanner=new Scanner(System.in);
        String[] strings=null;
        strings=scanner.nextLine().split(" ");

        if(strings==null||strings.length==0){
            return;
        }
        for(int i=0;i<strings.length;i++){
            Node n=new Node(Integer.valueOf(strings[i]));
            p.next=n;
            n.pre=p;
            p=p.next;
            tail=p;
        }
        while (p.sno!=-1){
            System.out.print(p.sno+" ");
            p=p.pre;
        }
    }
}
