package interview.duxiaoman;

class Father{
    public Father(){
        System.out.println("a");
    }
    public Father(int x){
        System.out.println("a"+x);
    }
}
public class Test extends Father{
    public Test(int x){
        System.out.println("b"+x);
    }

    public static void main(String[] args) {
        Test test=new Test(2);
    }
}
