import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSync {
    public static void main(String[] args) throws InterruptedException {
        //add() and remove() methods are synchonized
        //intrinsic lock - not theat efficient because threads
        // have to watit for each other even when the want to execute
        //independent methods
        //concurrentcollections are the anserrs the propblems!!!!!
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                           nums.add(i);
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    nums.add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(nums.size());



    }
}
