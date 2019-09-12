package interview.baidu;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

public class Money {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> listl=new ArrayList<>();
        for (int i=0;i<n;i++){
            list1.add(scanner.nextInt());
            list2.add(scanner.nextInt());
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<list2.size();i++){
            for(int j=0;j<list2.get(i);j++){
                list.add(list1.get(i));
            }
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            listl.add(arr[i]);
        }

        int sum=0;
        boolean flag=true;
        int i=0;
        int j=listl.size()-1;
        while (flag){
            if(listl.size()==0){
                break;
            }
            if (j==0){
                break;
            }
//            int s=0;
//            for(int k=0;k<listl.size();k++){
//                s+=listl.get(k);
//            }
//            if(s<m){
//                flag=false;
//            }
            i=0;
            if(listl.get(i)>=m){
                sum++;
                listl.remove(i);
                j=listl.size()-1;
                continue;
            }
            if(listl.get(i)+listl.get(j)>=m){
                listl.remove(i);
                listl.remove(--j);
                sum++;
                j=listl.size()-1;
                continue;
            }else {
                j--;
            }
        }
        System.out.println(sum);
    }
}
