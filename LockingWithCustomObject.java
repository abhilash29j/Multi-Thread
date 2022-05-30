public class LockingWithCustomObject {
    public static int counter1 = 0;
    public static int counter2 = 0;
    //there is a single intrinsic lock associated with every objects or class in javA
    //a given thread that needs exclusive and consistent access to an object's fields
    //has to acquire the object's intrinsic lock before accessing them,
    //and then the thread releases the instrinsic lokc when it's done with them
    //with locks: the acquire lock can be released any thread
    //RLocks can be releasd by the thread that acquired it exclusively
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();//creating our custom object for locking the given synchozized block
    //which mean they are not using the sam eintrinsic lock of a class or object
    public static void increment1() {
        //at the same time != paraller - cpu time sachedueling
        synchronized (lock1) {
            counter1++;
        }

    }

    public static synchronized void increment2() {  //if we use synchronized keyword we get whole instrinsic lock
        //of object or class itself then other can't access the other methods
        synchronized (lock2) {
            counter2++;
        }

    }
    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment2();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("The counter1 is  " + counter1);
        System.out.println("the counter2  is " + counter2);
    }

    public static void main(String[] args) throws InterruptedException {
        process();
    }

}
