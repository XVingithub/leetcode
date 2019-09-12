package interview.xiaomi;

import java.util.*;
public class add {

        public static void main(String[] args){
            Scanner sca= new Scanner(System.in);

            int a=sca.nextInt();
            int[][] arr= new int[a][a];
            int[] a1=new int[a*a];
            for(int i=0;i<a;i++){
                for(int j=0;j<a;j++){
                    arr[i][j]=sca.nextInt();
                }
            }
            int index=0;
            for(int i=0;i<a;i++){
                for(int j=0;j<a;j++){
                    a1[index]=arr[j][i];
                    index++;
                }
            }
            System.out.println(Sum(a1));
        }
        public static int Sum(int[] arr){
            int max=Integer.MIN_VALUE;
            int sum;
            for(int i=0;i<arr.length;i++){
                sum=0;
                for(int j=i;j<arr.length;j++){
                    sum+=arr[j];
                    if(sum>max){
                        max=sum;
                    }
                }
            }
            return max;
        }


}
