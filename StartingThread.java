class Runner1 implements  Runnable{
    public void run() {
        for (int i =0 ;i < 1000 ;i++) {
            System.out.println("Runner1 : "+ i);
        }
    }
}

class Runner2 implements Runnable{
    public void run() {
        for (int i =0 ;i < 1000 ;i++) {
            System.out.println("Runner2 : "+ i);
        }
    }
}
  //multithreading execution with time-slicing
// paralleism one ofthe cpu is hanglind one thread other core is handling thread 2
//this is not parallelism but multithredding using time slicing algorithm
public class StartingThread {
    public static void main(String[] args) {
     //achieved mulitthreading
//        Thread t1 = new Thread(new Runner1());    //jvm calls the run method of this thread
    //we can also does this using anonymous class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ;i < 1000 ;i++) {
                    System.out.println("Runner1 : "+ i);
                }
        };});
        Thread t2 = new Thread(new Runner2());
    t1.start();
    t2.start();





    }

}
