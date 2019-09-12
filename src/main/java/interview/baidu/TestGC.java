package interview.baidu;

public class TestGC {
    private static TestGC TEST_GC=null;
    private void isAlive(){
        System.out.println("Yes,I'am Alive!"+"、");
    }
    @Override
    protected void finalize() throws  Throwable{
        super.finalize();
        System.out.println("finalize method executed!"+"、");
        TestGC.TEST_GC=this;
    }
    public static void main(String[] args) throws Throwable{
        TEST_GC=new TestGC();
        TEST_GC=null;
        System.gc();
        Thread.sleep(500);
        if(TEST_GC!=null){
            TEST_GC.isAlive();
        }else {
            System.out.println("No,I'm dead!"+"、");
        }
        TEST_GC=null;
        System.gc();
        Thread.sleep(500);
        if(TEST_GC!=null){
            TEST_GC.isAlive();
        }else {
            System.out.println("NO,iam dead!");
        }
    }
}
