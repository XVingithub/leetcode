package interview.baidu;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static int test(){
        int a=20;
        try {
            return a+25;
        }catch (Exception e){
            System.out.println("e");
        }finally {
            System.out.println(a+" ");
            a=a+10;
        }
        return a;
    }
}
