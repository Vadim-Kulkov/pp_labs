package fourth_lab.services;

import fourth_lab.interfaces.Person;

import java.io.*;

public class Serializator {

    /**
     * Вывод сериализованных объектов
     */
    public static void serialize(Person o, OutputStream out) {
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

    /**
     * Ввод десериализованного объекта
     */
    public static Person deSerialize(InputStream in) {
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
}
