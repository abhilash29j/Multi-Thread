import java.util.concurrent.Exchanger;

class FirstThread implements  Runnable{
     private int counter;
     private Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        //it will run forever
        while (true) {
            counter++;
            System.out.println("First thread incremented the counter "+ counter);
            try {
                counter = exchanger.exchange(counter);
                System.out.println("Frist thread get the counter: " +counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}







    class SecondThread implements  Runnable{
private int counter;
private Exchanger<Integer> exchanger;

public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
        }

@Override
public void run() {
        //it will run forever
        while (true) {
        counter--;
        System.out.println("Second thread decremented the counter "+ counter);
        try {
        counter = exchanger.exchange(counter);
            System.out.println("Second thread get the counter: " +counter);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }
        }

        }
        }





public class ExchangerExam {
    //witht the help of Exchanger - > two threads can exchgnage objects
    // exchange() -> exchanging objects is done via one of the two exchgange() methods
    public static void main(String[] args) {
   Exchanger<Integer> exchanger = new Exchanger<>();
   FirstThread t1 = new FirstThread(exchanger);
   SecondThread t2 = new SecondThread(exchanger);
   new Thread(t1).start();
   new Thread(t2).start();
    }
}
