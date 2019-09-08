package stack;

import java.util.Stack;

/**
 * leetcode 42 困难
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 */
public class Rain {
    public int trap(int[] height) {
        Stack<Integer> stack=new Stack<>();
        int current=1;
        int sum=0;
        while (current<height.length){
            while (!stack.isEmpty()&&height[current]>height[stack.peek()]){
                int h=height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int distance=current-stack.peek()-1;
                int min=Math.min(height[current],height[stack.peek()]);
                sum=sum+distance*(min-h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
