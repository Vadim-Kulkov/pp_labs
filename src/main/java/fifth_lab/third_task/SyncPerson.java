package fifth_lab.third_task;

import fourth_lab.entities.Entrant;
import fourth_lab.exceptions.SpecialException;
import fourth_lab.exceptions.SpecialRuntimeException;
import fourth_lab.interfaces.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

public class SyncPerson implements Person {
    /**
     * Поле-массив - баллы по экзаменам
     */
    private volatile int[] examScores;

    /**
     * Поле строкового типа - фио
     */
    private volatile String sign;

    /**
     * Поле целого типа - id
     */
    private volatile int id;

    /**
     * Конструктор по умолчанию
     */
    public SyncPerson(Person person) {
        this.examScores = person.getExamScores();
        this.sign = person.getSign();
        this.id = person.getId();
    }

    /**
     * Конструктор с параметрами, позволяющий полностью инициализировать объект
     */
    public SyncPerson(int[] examScores, String sign, int id) {
        this.examScores = examScores;
        this.sign = sign;
        this.id = id;
    }

    /**
     * Функциональный метод, подсчитывающий средний балл
     */
    @Override
    public synchronized int findAverageExamScores() throws SpecialException {
        if (examScores.length == 0) {
            throw new SpecialRuntimeException("The divisor must be not zero");
        }
        if (examScores == null) {
            throw new SpecialException("Exam scores must be not null");
        }
        return Arrays.stream(examScores).sum() / examScores.length;
    }

    /**
     * Реализация output
     */
    @Override
    public synchronized void output(OutputStream out) {
        try {
            out.write(new byte[]{1, 2, 3, 4, 5});
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
     * Реализация write
     */
    @Override
    public synchronized void write(Writer out) {
        try {
            out.write("Some data");
        } catch (IOException e) {
            System.err.println("Error of write");
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
     * Методы доступа к элементам массива
     */
    @Override
    public synchronized int[] getExamScores() {
        return examScores;
    }

    @Override
    public synchronized void setExamScores(int[] examScores) {
        this.examScores = examScores;
    }

    @Override
    public synchronized String getSign() {
        return sign;
    }

    @Override
    public synchronized void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public synchronized int getId() {
        return id;
    }

    @Override
    public synchronized void setId(int id) {
        this.id = id;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entrant entrant = (Entrant) o;
        return getId() == entrant.getId()
                && Arrays.equals(getExamScores(), entrant.getExamScores())
                && Objects.equals(getSign(), entrant.getSign());
    }

    @Override
    public synchronized int hashCode() {
        return Objects.hash(getSign(), getId()) + Arrays.hashCode(getExamScores());
    }

    @Override
    public synchronized String toString() {
        final StringBuilder sb = new StringBuilder("Entrant{");
        sb.append("examScores=").append(Arrays.toString(examScores));
        sb.append(", sign=").append(sign);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
