import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExa {

    private Lock lock1 = new ReentrantLock(true);
    private  Lock lock2 = new ReentrantLock(true);


    public static void main(String[] args) {
         DeadLockExa deadLock = new DeadLockExa();
         //after java 8 it is possible to crerate thread like this
         new Thread(deadLock::worker1,"worker1").start();
        new Thread(deadLock::worker2,"worker2").start();
    }

    public void worker1() {
    lock1.lock();
        System.out.println("Worker1 acuires the lock1");
        try {
            Thread.sleep(300);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("Worker1 acquired the lock2");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        lock2.lock();
        System.out.println("Worker2 acuires the lock2");
        try {
            Thread.sleep(300);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        System.out.println("Worker2 acquired the lock1");
        lock1.unlock();
        lock2.unlock();
    }



}
