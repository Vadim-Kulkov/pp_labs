package fourth_lab.app;

import fourth_lab.entities.Entrant;
import fourth_lab.entities.Student;
import fourth_lab.interfaces.Person;
import fourth_lab.services.ReaderWriter;
import fourth_lab.services.Serializator;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person person;
        String type;
        String sigh;
        int[] examScores;
        int id;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите тип объекта Entrant/Student: ");
        type = scanner.nextLine();

        System.out.print("Введите баллы за экзамены через пробел: ");
        String[] value = scanner.nextLine().split(" ");
        examScores = new int[value.length];
        for (int i = 0; i < value.length; i++) {
            examScores[i] = Integer.parseInt(value[i]);
        }

        System.out.print("Введите фамилию: ");
        sigh = scanner.nextLine();

        System.out.print("Введите id: ");
        id = Integer.parseInt(scanner.nextLine());

        if (type.contains("Entrant")) {
            person = new Entrant(examScores, sigh, id);
        } else {
            person = new Student(examScores, sigh, id);
        }

        testReadeWriterBytes(person);
        testReadeWriterSymbols(person);
        serializationTest(person);
    }

    private static void testReadeWriterBytes(Person person) {
        System.out.println("Байтовые методы");
        try (FileOutputStream fileOutputStream = new FileOutputStream("database.bin")) {
            ReaderWriter.output(person, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fileInputStream = new FileInputStream("database.bin")) {
            System.out.println(ReaderWriter.input(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testReadeWriterSymbols(Person person) {
        System.out.println("Символьные");
        try (FileWriter fileWriter = new FileWriter("SecondDataBase.txt")) {
            ReaderWriter.write(person, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("SecondDataBase.txt")) {
            System.out.println(ReaderWriter.read(fileReader));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serializationTest(Person person) {
        System.out.println("Сериализация");
        try (FileOutputStream fileOutputStream = new FileOutputStream("SerializationDataBase.bin")) {
            Serializator.serialize(person, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("SerializationDataBase.bin")) {
            System.out.println(Serializator.deSerialize(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}