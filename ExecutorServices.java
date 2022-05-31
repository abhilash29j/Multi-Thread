public class ExecutorServices {
    //withh the incresase in the number of the coreses availble in the processors nowadays, mulithtreading is getting more and more crucial
    //java provides its own multi-threading framwwork the so-called executor framwrork
    //with the help of this framework we can manage worker threads more efficiently because of the thread pools
    // using thread pools makes multithreading efficient

    //why  to use thread pools and the executor framwrokd?
    // it will handle everything : scheduel  and exevute the submitted tasks
    //creating and managing threads is expensive
    //adding a new thread for each process leads tot he creation of a large number of threads
    //threads needs memory + cpu will spend too  much time switching context when the threads are swapped

    //Threads pools can reuse thrads in an extremely efficient manner by keeping the threads alive and reusing them (thread pools are usually quesues)

    //htrere are sefveral types of exxecutors;
    //1) single thread executor
      //this executor has a single thread so we can execute processs in a sequential manner. Every process is executed by a new thread
    //2.) FixedThreadPool(n)

      // this is how we can create a thread pool with n threads. Usually n is the number of cores in the cpu
    // if there are more tasks than n then these tasks are stored with a linkedBlockingQueue data structure

    //3.cached thread pool
    // the number of threads is not bounded: if all th ethreads are busy //
    //executing some tasks and an ew task comes the pool willc reate and add a new thread to the executor.
    //if a thread remains idle for 60 secs then it is removed
    //it is used for short parallel tasks

    //4.) schedule executor
    // we can execute a given operation at regualr intervals or we can use this executor if we wish to delay a certain task

    public static void main(String[] args) {

    }
}
