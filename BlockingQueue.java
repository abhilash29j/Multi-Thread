import java.util.concurrent.ArrayBlockingQueue;

class FirstWork implements  Runnable{
  private java.util.concurrent.BlockingQueue<Integer> queue;

    public FirstWork(java.util.concurrent.BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
    int counter  = 0;
    while (true) {
        try {
            queue.put(counter);
            System.out.println("Putting items into the queue "+ counter);
            counter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}


class SecondWork implements  Runnable{
    private java.util.concurrent.BlockingQueue<Integer> queue;

    public SecondWork(java.util.concurrent.BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int counter = queue.take();
                System.out.println("taking items from  the queue "+ counter);
                counter++;
                Thread.sleep(300); //do with 3000 also
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}









public class BlockingQueue {
    //queue has fifo structure () but it is not a synchonized data structure!!
    //blockding queue->> an interface that reprensts a queue that is thread safe put items or take items from it...
    //for example: one thread putting items into the queue and another thread taking items from it at the same time!!!
    //we can do the producer-sconsuemr pattern!!!
    //put() putting items to the queue()
    //take() taking items from the queue

    public static void main(String[] args) {


        java.util.concurrent.BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        FirstWork firstWork = new FirstWork(queue);
        SecondWork secondWork = new SecondWork(queue);
        new Thread(firstWork).start();
        new Thread(secondWork).start();
    }
}
