import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

enum Downloader {
    INSTANCE;
   private java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(5,true);
    public void download()  {

        try {
            semaphore.acquire();
            downloadData();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }

    private void downloadData(){
        try {

            System.out.println("downloading data from the web");
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}

public class Semaphoree {

    //it is used to control access to a shared resource that uses
    //a counter variable
        //semaphore maintains a set of permits
    //-acquire()... if a permit is avaialbe then takes it
    // release().. adds a permit
    //semaphore just keeps a count of the number of permits available
    //new semaphore (int permits, boolean fair)!!!

    public static void main(String[] args) {


        //create multiple threads- executors
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
      service.execute(new Runnable() {
          @Override
          public void run() {
              Downloader.INSTANCE.download();
          }
      });
        }


    }
}
