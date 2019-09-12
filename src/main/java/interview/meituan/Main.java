package interview.meituan;

import java.util.Scanner;

class PrizePool{
    char a='A';
    char b='B';
    char c='C';
}
class Pingjia implements Runnable {
    int i;
    PrizePool prizePool=new PrizePool();
    public Pingjia(int a){
        i=a;
    }
    @Override
    public void run() {
        synchronized (this){
            if(i%2!=0){
                bonus(prizePool);
            }
            if(i%2==0&&i%4==0){
                contribution(prizePool);
            }else if (i%2==0&&i%4!=0){
                coupon(prizePool);
            }
        }

    }

    public void bonus(PrizePool prizePool){
        System.out.print(prizePool.a);
    }
    public void coupon(PrizePool prizePool){
        System.out.print(prizePool.b);
    }
    public void contribution(PrizePool prizePool){
        System.out.print(prizePool.c);
    }
}
class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            Pingjia pingjia=new Pingjia(i+1);
            Thread p=new Thread(pingjia,pingjia+"i");
            p.start();
        }
    }
}
