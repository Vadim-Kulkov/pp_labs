package sixth_lab.app;

import sixth_lab.entities.Student;
import sixth_lab.interfaces.Person;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Person person = new Student(new int[]{100, 200, 300, 500, 1000}, "Ivanov", 12);
        System.out.println("Second task");
        for (int i : person.getExamScores()) {
            System.out.print(i + " ");
        }
        System.out.println();
        Iterator<Integer> iterator = person.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}