import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Proces implements Callable<String> {
    private int id;
    public Proces (int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Id: "+this.id;
    }
}

public class RunnableAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
          ExecutorService executorServices = Executors.newFixedThreadPool(2);
          List<Future<String>> list = new ArrayList<>();
          for (int i = 0; i < 5; i++) {
              Future<String>  future= executorServices.submit(new Proces(i + 1));
              list.add(future);
          }
          for (Future<String> f :list)
              System.out.println(f.get());
    }
}
