package interview.fiveeight;

import java.util.*;
public class Cookie {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nian=new int[n];
        for(int i=0;i<n;i++){
            nian[i]=scanner.nextInt();
        }
        int[] qian=new int[n];
        for(int i=0;i<n;i++){
            qian[i]=1;
        }
        int cur=1;
        int x=0;
        while(cur==1){
            cur=0;
            for(int i=0;i<n;i++){
                if(i==0){
                    if(nian[i+1]<nian[i]){
                        x=qian[i];
                        qian[i]=Math.max(x,qian[i+1]+1);
                        if(x!=qian[i]) {
                            cur = 1;
                        }
                    }
                }else if(i==(n-1)){
                    if(nian[i-1]<nian[i]){
                        x=qian[i];
                        qian[i]=Math.max(x,qian[i-1]+1);
                        if(x!=qian[i]) {
                            cur = 1;
                        }
                    }
                }else{
                    if(nian[i-1]<nian[i]){
                        x=qian[i];
                        qian[i]=Math.max(x,qian[i-1]+1);
                        if(x!=qian[i]) {
                            cur = 1;
                        }
                    }
                    if(nian[i+1]<nian[i]){
                        x=qian[i];
                        qian[i]=Math.max(x,qian[i+1]+1);
                        if(x!=qian[i]) {
                            cur = 1;
                        }
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+qian[i];
        }
        System.out.println(sum);
    }

}