class WTR1 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("R1 : " + i);
        }
    }
}
class WTR2 extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 1000; i++) {
            System.out.println("R2 : " + i);
        }
    }
}
public class WaitThread {
    public static void main(String[] args) throws InterruptedException {
       WTR1 t1 = new WTR1();
        WTR2 t2= new WTR2();
        t1.start();
        t2.start();
        //we can wait for the thread to finish :Join()
        t1.join();
        t2.join();
        System.out.println("finished with thread");
   //the main thread is the lasst thread to finish execution because it performs various shutdowns operation

    }
}
