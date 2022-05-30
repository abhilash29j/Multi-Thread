class Process {
    public void produce() throws  InterruptedException {
      synchronized (this) {
          System.out.println("Running the produce method...");
          wait();
          System.out.println("again in the producer mehtods");
      }
    }
    public void consume() throws  InterruptedException {
   Thread.sleep(1000);
   synchronized (this) {
       System.out.println("Consumer method is executing");
       notify();
       //it is not going to handle he lock we can make further operations
       Thread.sleep(5000);
   }
    }

}

public class WaitAndNotify {
    //these wait () and notify() methods can be used and called from synchonized
     //methods or blocks exclusively


    public static void main(String[] args) throws InterruptedException {


        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
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
