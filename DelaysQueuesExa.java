import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelaysQueuesExa {
    //this is an unbounded blockingqueue of objects that implemnt delated interface

    // delayqueue keeps the elements internally until a certain delay has exprired
    //an object can only be taken from the queue when its delay has expired!!!

    //we cannot place null items in the queue - the queue is sorted so that tha object at the head has a delay
    //that has expired for the longest time

    //if no delay has expirred there is no head element and poll() method will return null
    //size() return the count of both expired and unexpired items!!!
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayWorker> queue = new DelayQueue<>();

        //these can be isnerted by differnet threads
        queue.put(new DelayWorker(2000,"This is the first message..."));
        queue.put(new DelayWorker(10000,"This is the second message..."));
        queue.put(new DelayWorker(4500,"This is the third message..."));

        //we can get the messages

        while(!queue.isEmpty()) {
            System.out.println(queue.take());
        }


    }
}


class DelayWorker implements Delayed {


    private long duration;
    private String message;

    public DelayWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {


        return unit.convert(duration - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        //this is the method that can compare objects
        //-1,+1,0
        if (duration < ((DelayWorker)other).getDuration())
            return -1;
       else if (duration > ((DelayWorker)other).getDuration())
            return +1;


        return 0;
    }

    @Override
    public String toString() {
        return "DelayWorker{" +
                "duration=" + duration +
                ", message='" + message + '\'' +
                '}';
    }
}
