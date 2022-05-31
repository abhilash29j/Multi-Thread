import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worke implements  Runnable{
private int id;
private CountDownLatch latch;
public  Worke(int id ,CountDownLatch latch) {
    this.id = id;
    this.latch = latch;
}
    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void doWork() throws InterruptedException {
        System.out.println("thread with id: " + id +" startt working");
    Thread.sleep(2000);
    }
}


public class Latch {
    //this is used to synchrozize on emore tasks by forciing them to wait for the completion of a set of operations being performed by other tasks
    //   you give an initial count to a countdownlatch object, and any task that calls await() on that object will block until count reaches zero
    //other tasks may call countDown() on the object tot reduce the count, preseumbly when a task finishes its job
    //a countdownlatch is designed to be used in a one-shot fashion and the ocunt cannot be reset!!!!

    //if you need a version that resets the count, you can use a cyclicbarrier instead
    //the tasks that call countDown() are not blocked when they make that call.
    // only thecall to await() is blocked until the ccount reaches zero

    // a typical use-case is to divide a problem in to nindependently solvable taasks and create a countdonwlatch with a value of N
    //when each task is finished it calls countDown() on the latch. Tasks waiting for the problem to be solved call await() on the latch to hold thmselves back until it is completed
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService services = Executors.newSingleThreadExecutor();
        for ( int i = 0; i < 5; i++) {
            services.execute(new Worke(i,latch));
        }
        latch.await();
        System.out.println("all tasks have been finished");
        services.shutdown();
    }

}
