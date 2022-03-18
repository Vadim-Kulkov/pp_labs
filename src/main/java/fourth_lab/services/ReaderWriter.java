package fourth_lab.services;

import fifth_lab.third_task.SyncPerson;
import fourth_lab.interfaces.Person;

import java.io.*;

public class ReaderWriter {

    private ReaderWriter() {
    }

    public static void output(Person o, OutputStream out) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(o);
        } catch (IOException e) {
            System.err.println("Error of write");
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.err.println("Error of close");
                e.printStackTrace();
            }
        }
    }

    public static Person input(InputStream in) {
        try (ObjectInputStream inputStream = new ObjectInputStream(in)) {
            return (Person) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void write(Person o, Writer out) {
        try {
            out.write(o.toString() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String read(Reader in) {
        try (BufferedReader reader = new BufferedReader(in)) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Метод, возвращающий обёртку
     */
    public Person getSyncPerson(Person person) {
        return new SyncPerson(person);
    }
}