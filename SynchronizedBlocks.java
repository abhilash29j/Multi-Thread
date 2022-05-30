public class SynchronizedBlocks {
    public static int counter1 = 0;
    public static int counter2 = 0;


    //this ic alled object level locking because we get the monitor lock (intrinsic lock ) associated
    //with the object itself
    //this is called level locking bacuse we get the monoitor lock associtated with the class(not use this keyworkd user classname.class)
    //usually it is not a good practice to use synchronized keyword

//    public static synchronized  void increment1() {
//        counter1++;
//    }
    public static  void increment1() {
        //class level locking
        //rule of thumb: we synchrozize blocks that are 100% necessary
        synchronized (SynchronizedBlocks.class) {
            counter1++;
        }
    }
    public static synchronized  void increment2(){
        counter2++;
    }
    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000 ; i++)
                    increment1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment2();
            }
        });
  t1.start();
  t2.start();
  t1.join();
  t2.join();
        System.out.println("The counter1 is  " + counter1);
        System.out.println("the counter2  is " + counter2);

    }

    public static void main(String[] args) throws InterruptedException {

        //every object in  java has a so-called intrinsic lock
        //because of the monitor lock: no 2 threads can execute the same synchronized mehtod
        //at the same time

        //a thread that needs exclusive kand consistent access to an object's fields
        //has to acquire the object's intrinsic lock before accessing them,and then
        // release the intrinsic lock when it's done with them"



//every single object in java has a single monitor lock
        //if we have 2 independent synchonized methods than the
        //threads have to wait for each other to release the lock
   process();
    }
}
