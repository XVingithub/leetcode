package interview.xiaomi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Game2048 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String[] solution(String[] input) {
        String[] res = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            String[] strings = input[i].split(" ");
            StringBuffer st = new StringBuffer();
            int[] data = new int[strings.length];
            int start = -1;
            int sum = 0;
            for (int j = 0; j < data.length; j++) {
                data[j] = Integer.valueOf(strings[j]);
                if (data[j] != 0 && start == -1) {
                    start = j;
                }
            }
            for (int j = start; j < data.length - 1; j++) {
                if (data[j] == data[j + 1]) {
                    data[j] = data[j] * 2;
                    data[j + 1] = 0;
                } else if (data[j] == 0) {
                    continue;
                }
            }

            for (int j = start; j < data.length; j++) {
                if (data[j] != 0) {
                    st.append(data[j] + " ");
                    sum++;
                }
            }
            for (int j = sum; j < data.length; j++) {
                st.append(0 + " ");
            }
            res[i] = st.toString();
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}