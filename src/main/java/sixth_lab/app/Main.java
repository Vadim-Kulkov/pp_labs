package sixth_lab.app;

import sixth_lab.entities.Student;
import sixth_lab.interfaces.Person;
import sixth_lab.services.ReaderWriter;
import sixth_lab.services.Serializator;

import java.io.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Person person = new Student(new int[]{100, 200, 300, 500, 1000}, "Ivanov", 12);
        for (int i : person.getExamScores()) {
            System.out.print(i + " ");
        }
        System.out.println();
        Iterator<Integer> iterator = person.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
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