import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BarrierW implements  Runnable{
   private int id;
   private Random random;
   private java.util.concurrent.CyclicBarrier barrier;

    public BarrierW(int id,java.util.concurrent.CyclicBarrier barrier) {
        this.id = id;
        this.random = new Random();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            doWork();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
    private void doWork() throws InterruptedException, BrokenBarrierException {
        System.out.println("Thread with ID " + this.id+ " starts the work ");
        Thread.sleep(random.nextInt(3000));

        //when all the threads call await  as many as times when nunmer of threads we have difened in barrier
        //after the barrier is broken then ....
        barrier.await();

    }

}

public class CyclicBarrier {
    //CyclicBarrier -> multiple threads can wait for each other whereeas in latch a single thread can wait for other threads
    //A cyclic barrier is used in situraion where you want to create a group of tasks to perform work in a concurrent manner + waut until they are all finished before moving on to
    //the next step
    //   something like join()
    //   something like countDownLatch


    //countDownLatch: one-shot event
    //cyclicBarrie: it can be reused over and over agagin
        //+  cyclcicBarrier has a barrier action: a runnable, that will run automatically when the count reaches 0!!1
        //new CuclicBarrier(N) -> N threads willl wait for each other
    //we can not reuse lactchs but we can reuse clci barrier --< resets()

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);


        //5 is the number of threads we are dealings
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks have been finsihed");
            }
        });
        for (int i = 0; i < 5; i++) {
            service.execute(new BarrierW(i + 1,barrier));
        }
        service.shutdown();

    }


}
