package fifth_lab.first_task;

import third_lab.entities.Student;
import third_lab.interfaces.Person;

public class Main {

    public static void main(String[] args) {

        Person person = new Student(new int[10], "Ivan", 21);
        Thread producer = new Thread(new Producer(person, person));
        Thread consumer = new Thread(new Consumer(person, person));

        producer.start();
        consumer.start();
    }
}
