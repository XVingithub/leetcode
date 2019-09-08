package stack;

import java.util.Stack;

/**
 * leetcode 20 简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */
public class Bracket {
    public static void main(String[] args) {

    }
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();
        for(char achar:chars){
            if(stack.isEmpty()){
                stack.push(achar);
            }else if(isSys(stack.peek(),achar)){
                stack.pop();
            }else{
                stack.push(achar);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public boolean isSys(char a,char b){
        if((a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}')){
            return true;
        }
        return false;
    }
}
