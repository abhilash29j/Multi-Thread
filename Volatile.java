class Wor implements  Runnable{
  //it will strore in the main memory
    private volatile boolean terminated;

    @Override
    public void run() {
         while (!terminated){//it is also way of stopping a thread //we can also use thread.stop() but is is unsafe not recommended
             System.out.println("workidng class is running");
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
    }

    public boolean isTerminated() {
        return  terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;

    }

}

public class Volatile {
    public static void main(String[] args) throws InterruptedException {
        Wor worker = new Wor();
        Thread t1 = new Thread(worker);
        t1.start();
       Thread.sleep(3000);
        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");


    }
}
