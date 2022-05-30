import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Workerr {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void produce() throws  InterruptedException {
        lock.lock();
        System.out.println("Producer method..");
        condition.await();//similar to wait method
        System.out.println("Again into the producer method");
        lock.unlock();
    }
    public void consume() throws  InterruptedException{
//we want to make sure that we start with the procuer()
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method..");
        Thread.sleep(3000);
        //notify
        condition.signal();
        lock.unlock();

    }

}



public class ProducerAndConsumerWithReentrantLock {
    public static void main(String[] args) throws InterruptedException {

        Workerr work = new Workerr();



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    work.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    work.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
     //   System.out.println(counter);
    }
}
