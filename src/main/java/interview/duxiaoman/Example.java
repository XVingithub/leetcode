package interview.duxiaoman;

public class Example {
    private int cnt2;
    int cnt1=0;
    public void m(){
        cnt1+=2;
        cnt2+=2;
        System.out.println(cnt1+" "+cnt2);
    }
}
class MyThread extends Thread{
    private Example i;
    public MyThread(Example i){
        this.i=i;
    }
    public void run(){
        synchronized (i){
            i.m();
        }
    }
}
class ThreadTest {
    public static void main(String[] args) {
        Example mv=new Example();
        Thread t1=new MyThread(mv);
        Thread t2=new MyThread(mv);
        Thread t3=new MyThread(mv);
        t1.start();
        t2.start();
        t3.start();
    }
}
