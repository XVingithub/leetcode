package interview.xiaomi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int summ(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length-1;i++){
            sum+=arr[i+1]-arr[i];
        }
        return sum;
    }
    static int solution(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length-1;i++){
            for (int j=i;j<arr.length;j++){
                int sum1=summ(arr);
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                int sum2=summ(arr);
                sum+=Math.max(sum1,sum2);
            }
        }
        return sum;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
