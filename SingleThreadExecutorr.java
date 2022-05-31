import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements  Runnable {
    private int id;
    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id "+id+" is in work - thread id : "+ Thread.currentThread().getName());
   long duration  = (long)Math.floor(Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SingleThreadExecutorr {
    public static void main(String[] args) {
        //it is a single thread that wiil execute the task sequentially one after the other
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i <  5; i++) {
            executorService.execute(new Task(i+ 1));
        }

        //appliaiton is not terminate we have to shutdown executor service

    }
}
