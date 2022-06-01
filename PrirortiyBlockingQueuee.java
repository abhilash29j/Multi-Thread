import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker implements  Runnable {
   private PriorityBlockingQueue<String> queue;

    public FirstWorker(PriorityBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            queue.put("X");
            queue.put("R");
            queue.put("F");
            Thread.sleep(2000);
            queue.put("G");
            Thread.sleep(1000);
            queue.put("D");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}





class SecondWorker implements  Runnable {
    private PriorityBlockingQueue<String> queue;

    public SecondWorker(PriorityBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            Thread.sleep(4000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}





public class PrirortiyBlockingQueuee {
    //it implemnets  the blockingQueue  interface

    ///    - -- unbounded concurrent queue
      //   -- it uses the same ordering rules as the java.util.PriotirtyQueue class and we
    //have to implement the Comparable interface
    // it determines what will the order in the queue
    //The priority can be the same compare() == 0 case
    //no null items are allowed!!!
    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();
        FirstWorker first = new FirstWorker((PriorityBlockingQueue<String>) queue);
        SecondWorker second = new SecondWorker((PriorityBlockingQueue<String>) queue);
        new Thread(first).start();
        new Thread(second).start();
    }
}
