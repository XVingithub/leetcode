package interview.baidu;

public class Test implements Runnable {
    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            synchronized (this){
                try {
                    wait();
                }catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
        }
        System.out.println("Final");
    }
    public static void main(String[] args) throws InterruptedException{
        Thread thread=new Thread(new Test());
        thread.start();;
        new Thread(()->{
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            thread.interrupt();
            System.out.println("interrupt");
        }).start();
        thread.join();
        System.out.println("exit");
    }
}
