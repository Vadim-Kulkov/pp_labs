package fifth_lab.second_task;

import java.util.concurrent.locks.Lock;

public class Writer implements Runnable {

    Synchronizer synchronizer;
    Lock lock;

    public Writer(Synchronizer synchronizer, Lock lock) {
        this.lock = lock;
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                synchronizer.read();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
