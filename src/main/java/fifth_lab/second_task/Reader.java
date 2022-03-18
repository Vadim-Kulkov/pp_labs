package fifth_lab.second_task;

import java.util.concurrent.locks.Lock;

public class Reader implements Runnable {

    Synchronizer synchronizer;
    Lock lock;

    public Reader(Synchronizer synchronizer, Lock lock) {
        this.lock = lock;
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                synchronizer.write();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
