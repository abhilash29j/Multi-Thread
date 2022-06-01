import java.util.Map;

public class ConcurrentHashMap {
    //we can make a map synchonized with the help of the Collections class
    //not an efficient solution
    //it uses the intrinsic lock which means that independent operations may have
    //to wait for each other!

    //concurrenthashmaps we an make a map synch with defiening semaents of the underlying array
    // these segments(16 items) can be updated only by a single thread

    //we assign a lock to every segment in insetead of using a single lock!!!
    //every Thread can reaad any item from the underlying array without restricitons
    public static void main(String[] args) {
        java.util.concurrent.ConcurrentHashMap<String,Integer> map = new java.util.concurrent.ConcurrentHashMap<>();
        new Thread(new MapWorker(map)).start();
        new Thread(new MapWorkerSecond(map)).start();

    }


}


class MapWorker implements  Runnable {
    public MapWorker(java.util.concurrent.ConcurrentHashMap<String, Integer> map) {
        this.map = map;
    }

    private java.util.concurrent.ConcurrentHashMap<String,Integer> map;

    @Override
    public void run() {

        try {
            map.put("B" , 12);
            Thread.sleep(2000);
            map.put("Z",212);
            map.put("G",3);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


    class MapWorkerSecond implements  Runnable {
public MapWorkerSecond(java.util.concurrent.ConcurrentHashMap<String, Integer> map) {
        this.map = map;
        }

private java.util.concurrent.ConcurrentHashMap<String,Integer> map;

@Override
public void run() {

        try {
            Thread.sleep(5000);
            System.out.println(map.get("B"));
            Thread.sleep(2000);
            System.out.println(map.get("Z"));
            System.out.println(map.get("G"));

        } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }
        }
        }




