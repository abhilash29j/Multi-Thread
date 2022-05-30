import java.util.concurrent.TimeUnit;

class R1 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 1000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("R1 : " + i);
        }
    }
}
class R2 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 1000; i++) {
            System.out.println("R2 : " + i);
        }
    }
}


public class StartingThreadExtenThread {
    public static void main(String[] args) {
        Thread t1 = new R1();
        Thread t2 = new R2(); //jvm will going to start two threads and undlying os going to use time slicing algorthem to run threadsf
   t1.start();
   t2.start();
    }
}
