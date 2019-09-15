package interview.duxiaoman;

import javax.xml.ws.Service;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {
    private void test(){
        Set<Short> set = new TreeSet<Short>();
        for (Short k=0;k<20;k++){
            set.add(k);
            set.remove(k-1);
        }
        System.out.println(set.size());
    }

    static public void main(String[] a){
        new Test2().test();
    }

}
