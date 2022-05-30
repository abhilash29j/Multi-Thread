public class Synchronization {
    public static int counter = 0;

    public  static synchronized void increment() {//acquierin sunchornoize class
        counter++;
    }
    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                     increment();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i  < 10000; i++) {
                    increment();
                }
            }
        });
   t1.start();
   t2.start();
   t1.join();
   t2.join();


    }

    public static void main(String[] args) throws InterruptedException {
process();
        System.out.println(counter);
    }
}
