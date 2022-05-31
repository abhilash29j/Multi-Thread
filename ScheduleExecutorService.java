import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements  Runnable {

    @Override
    public void run() {
        System.out.println("dupdating and downloading stock realted data from the web");
    }
}
public class ScheduleExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new StockMarketUpdater(),1000,2000, TimeUnit.MILLISECONDS);
        executorService.shutdown();//nitiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. Invocation has no additional effect if already shut down.
       // This method does not wait for previously submitted tasks to


        //executorService.awaitTermination(1000,TimeUnit.MILLISECONDS); if it gives true
         // executorService.shutdownNow();  //Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
        //This method does not wait for actively executing tasks to terminate. Use awaitTermination to do that.
    }

    //how to stop executors service
    //we prevent the executor to execute any further tasks
    //exectuor.shutdown();
    //which mean it is not going to executo futherly


    //termiante eacutal(running) tasks


}
