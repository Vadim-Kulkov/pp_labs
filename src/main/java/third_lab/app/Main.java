package third_lab.app;

import third_lab.entities.Entrant;
import third_lab.entities.Student;
import third_lab.exceptions.SpecialException;
import third_lab.interfaces.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Person[] persons = new Person[10];

    private static Person[] onlyStudents = new Person[5];
    private static Person[] onlyEntrants = new Person[5];

    public static void main(String[] args) {
        init(persons);
        System.out.println("Вывести полную информацию об объектах массива");
        showInformationAboutPersons(persons);

        System.out.println();

        System.out.println("Одинаковые значения среднего балла");
        showInformationAboutPersons(findPersonsWithEqualsAverageExamScores(persons));

        System.out.println();
        System.out.println("Разбить исходный массив на два массива, в которых будут храниться однотипные элементы");

        castToTwoSpecialArrays(persons);


        showInformationAboutPersons(onlyEntrants);

        System.out.println();

        showInformationAboutPersons(onlyStudents);
    }

    private static void init(Person[] persons) {
        for (int i = 1; i <= persons.length; i += 2) {
            persons[i] = new Entrant(new int[]{49 + i, 91 - i, 10 * i}, "Boris", 42 * i);
        }
        for (int i = 0; i < persons.length; i += 2) {
            persons[i] = new Student(new int[]{60 + i, 50 + i, 40 - i}, "Vanya", 31 * i);
        }
    }

    /**
     * Вывести полную информацию об объектах массива
     */
    private static void showInformationAboutPersons(Person[] persons) {
        Arrays.stream(persons).forEach(System.out::println);
    }

    /**
     * Найти в массиве объекты, функциональный метод которых возвращают одинаковый результат,
     * поместить такие объекты в другой массив
     */
    private static Person[] findPersonsWithEqualsAverageExamScores(Person[] persons) {
        List<Person> result = new ArrayList<>();
        for (Person i : persons) {
            for (Person j : persons) {
                try {
                    if (i.findAverageExamScores() == j.findAverageExamScores()) {
                        result.add(j);
                    }
                } catch (SpecialException e) {
                    e.printStackTrace();
                }
            }
            if (result.size() > 1) {
                return result.toArray(Person[]::new);
            }
        }
        return new Person[0];
    }

    /**
     * Разбить исходный массив на два массива, в которых будут храниться однотипные элементы
     */
    private static void castToTwoSpecialArrays(Person[] persons) {
        onlyStudents = Arrays.stream(persons).filter(a -> a.getClass() == Student.class).toArray(Person[]::new);
        onlyEntrants = Arrays.stream(persons).filter(a -> a.getClass() == Entrant.class).toArray(Person[]::new);
    }
}
