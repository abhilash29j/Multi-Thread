import java.util.ArrayList;
import java.util.List;

class Processor {
    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private int value = 0;
    private final Object lock = new Object();

    public void producer() throws  InterruptedException {
          synchronized (lock) {
              while (true) {
                    if (list.size() == UPPER_LIMIT) {
                        System.out.println("waiting for rmoving items");
                        lock.wait();
                    }
                    else {
                        System.out.println("Adding " + value);
                        list.add(value);
                        value++;
                        //we can call the notify -because the other thread wiill be notified
                        //only when it is in a waiting state
                        lock.notify();

                    }
Thread.sleep(500);

              }
          }
    }
    public void consumer() throws  InterruptedException {

        synchronized (lock) {

            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    value = 0;
                    System.out.println("waiting for adding items");
                    lock.wait();
                }
                else {
                    System.out.println("removing " + list.remove(list.size()
                     - 1));


                    //we can call the notify -because the other thread wiill be notified
                    //only when it is in a waiting state
                    lock.notify();

                }

Thread.sleep(500);
            }
        }


    }

}

public class ProducerAndConsumer {


    public static void main(String[] args) throws InterruptedException {


        Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


}
