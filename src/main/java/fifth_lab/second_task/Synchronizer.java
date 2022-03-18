package fifth_lab.second_task;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Synchronizer {

    private Queue<Integer> integerQueue;
    private Lock lock;
    private static int SIZE;

    public Synchronizer(Queue<Integer> integerQueue, Lock lock, int SIZE) {
        this.integerQueue = integerQueue;
        this.SIZE = SIZE;
        this.lock = lock;
    }

    public void read() {
        synchronized (lock) {
            lock.notify();
            if (integerQueue.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (!integerQueue.isEmpty()) {
                System.out.println(integerQueue.remove());
            }
        }
    }

    public void write() {
        synchronized (lock) {
            int value;
            lock.notify();
            Random random = new Random();
            if (integerQueue.size() == SIZE) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (integerQueue.size() < SIZE) {
                value = random.nextInt(100);
                integerQueue.add(value);
                System.out.println("Produced: " + value);
            }
        }
    }
}
