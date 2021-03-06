package sixth_lab.services;

import sixth_lab.entities.PersonDecorator;
import sixth_lab.interfaces.Factory;
import sixth_lab.interfaces.Person;

import java.io.*;

public class ReaderWriter {

    private static Factory factory;

    private ReaderWriter() {
    }

    public ReaderWriter(Factory factory) {
        ReaderWriter.factory = factory;
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

    public static Person createInstance() {
        return factory.createInstance();
    }

    public Person unModifiable(Person o) {
        return new PersonDecorator(o);
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}