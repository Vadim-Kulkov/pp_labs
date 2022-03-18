package fifth_lab.first_task;

import third_lab.interfaces.Person;

public class Consumer extends Thread {

    Object lock;
    Person person;

    public Consumer(Object lock, Person person) {
        this.lock = lock;
        this.person = person;
    }

    private void consume() {
        synchronized (lock) {
            for (int i = 0; i < person.getExamScores().length; i++) {
                System.out.println("Read: " + person.getExamScores()[i] + " from position " + i);
            }
        }
    }

    @Override
    public void run() {
        consume();
    }
}
