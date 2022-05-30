class Wor implements  Runnable{
  private boolean terminated;

    @Override
    public void run() {
         while (!terminated){
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
