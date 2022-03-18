package fifth_lab.second_task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();
        Lock lock = new ReentrantLock();


        Synchronizer synchronizer = new Synchronizer(integerQueue, lock, 10);
        Thread writer = new Thread(new Writer(synchronizer, lock));
        Thread reader = new Thread(new Reader(synchronizer, lock));

        writer.start();
        reader.start();
        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
