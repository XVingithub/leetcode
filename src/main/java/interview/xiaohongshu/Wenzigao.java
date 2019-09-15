package interview.xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

public class Wenzigao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Stack<Character> stack=new Stack<>();
        String s=scanner.next();
        Character c;
        int flag=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)<='Z'&&s.charAt(i)>='A')||(s.charAt(i)<='z'&&s.charAt(i)>='a')||s.charAt(i)=='('){
                if(s.charAt(i)=='('){
                    flag++;
                }
                stack.push(s.charAt(i));
            }else if(s.charAt(i)=='<'&&flag==0&&!stack.isEmpty()){
                if((i<s.length()-1)&&(s.charAt(i+1)!='<')){
                    stack.pop();
                }
                if(i==s.length()-1){
                    stack.pop();
                }
            }else{
                if(s.charAt(i)==')'){
                    while (true){
                         c=stack.peek();
                         if(c!='('){
                             stack.pop();
                         }else {
                             stack.pop();
                             flag--;
                             break;
                         }
                    }
                }
            }
        }
        Stack<Character> stack1=new Stack<>();
        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        while (!stack1.isEmpty()){
            System.out.print(stack1.pop());
        }
    }
}
