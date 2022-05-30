import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    //ReentrantLock
    //it has the same behavior as the "synchronized approach"
    //of course it has some additionnal features
    //new reentrantLock(boolean fairness)
    //if the fairness parameter is set to be true then the longest
    // waiting thread will get the lock
    //if fairness is false then there is no access order
    //important : a good appraoch is to use try_catch_finally blocks when
    //doing the critical section and call unlock() in the finally block

  private static int counter = 0;
  private static Lock lock = new ReentrantLock();//default value for fairness is true
    private static void increment() throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {

                System.out.println(Thread.currentThread().getName() + " acquring lock");
                counter++;
                Thread.sleep(500);
            }
            }
        finally{
                lock.unlock();
            }


        }

    public static void main(String[] args) throws InterruptedException {
  Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
          try {
              increment();
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
  });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

  t1.start();
  t2.start();

  t1.join();
  t2.join();
        System.out.println(counter);
    }


}
