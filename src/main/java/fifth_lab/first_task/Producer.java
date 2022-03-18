package fifth_lab.first_task;

import third_lab.interfaces.Person;

import java.util.Random;

public class Producer extends Thread {

    Object lock;
    Person person;

    public Producer(Object lock, Person person) {
        this.lock = lock;
        this.person = person;
    }

    private void produce() {
        synchronized (lock) {
            Random random = new Random();
            for (int i = 0; i < person.getExamScores().length; i++) {
                int value = random.nextInt(999);
                person.getExamScores()[i] = value;
                System.out.println("Write: " + value + " to position " + i);
            }
        }
    }

    @Override
    public void run() {
        produce();
    }
}
