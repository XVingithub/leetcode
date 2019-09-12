package interview.meituan;

import java.util.Scanner;

class PrizePool{
    char a='A';
    char b='B';
    char c='C';
}
public class Pingjia implements Runnable {
    static int i=0;
    Scanner scanner=new Scanner(System.in);
    PrizePool prizePool=new PrizePool();
    int n=scanner.nextInt();

    @Override
    public void run() {
        i++;
        if(i%2!=0){
            bonus(prizePool);
        }
        if(i%2==0&&i%4==0){
            contribution(prizePool);
        }else if (i%2==0&&i%4!=0){
            coupon(prizePool);
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
