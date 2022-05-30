class DaemonWorker implements  Runnable {

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("daemon thread is running.");
        }
    }
}


class Worker implements  Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("normal thread is running.");
    }
}


public class DaemonThread {
    //daemon htreads are intended as helper threads (for ex gc)

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        //jvm going  to create main thread and daemon thread
        //hence we can create as many worker thread as we want child thread of main thread
        //dt are low priotiy thread that runs in background to perform task scuh as gc

        //usually we create daemon thread for i/o operitoins or services (smarthphones
        // serveice such as nfc or bluetooth communicaiton)
        //we can create a daemon thread for a smarthphone
        //application to look for smart-watches to pair with..
        //daemon threads are terminated by the JVM when all other
        //worker threads are terminated
        //

      Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new Worker());
      t1.setDaemon(true);
      t1.start();
      t2.start();
     //   System.out.println(t1.isDaemon());





//The typical difference is that threads(of the same process ) run in a shared memory space
        //,while processes run in separate memory space"



    }
}
