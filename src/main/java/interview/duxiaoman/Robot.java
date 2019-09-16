package interview.duxiaoman;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.next();
        int[] arr=new int[string.length()];
        for(int i=0;i<string.length();i++){
            arr[move(string,i)]++;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int move(String string,int i){
        int index=i;
        for(int j=0;j<Math.pow(10,string.length()/10+1);j++){
            index=string.charAt(i)=='L'?--i:++i;
        }
        return index;
    }
}
