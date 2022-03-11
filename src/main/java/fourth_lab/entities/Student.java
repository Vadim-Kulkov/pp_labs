package fourth_lab.entities;

import fourth_lab.exceptions.SpecialException;
import fourth_lab.exceptions.SpecialRuntimeException;
import fourth_lab.interfaces.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

public class Student implements Person {

    /**
     * Поле-массив - баллы по экзаменам
     */
    private int[] examScores;

    /**
     * Поле строкового типа - фио
     */
    private String sign;

    /**
     * Поле целого типа - id
     */
    private int id;

    /**
     * Конструктор по умолчанию
     */
    public Student() {
    }

    /**
     * Конструктор с параметрами, позволяющий полностью инициализировать объект
     */
    public Student(int[] examScores, String sign, int id) {
        this.examScores = examScores;
        this.sign = sign;
        this.id = id;
    }

    /**
     * Функциональный метод, подсчитывающий средний балл
     */
    @Override
    public int findAverageExamScores() throws SpecialException {
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
    public void output(OutputStream out) {
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
    public void write(Writer out) {
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
    public int[] getExamScores() {
        return examScores;
    }

    @Override
    public void setExamScores(int[] examScores) {
        this.examScores = examScores;
    }

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return getId() == student.getId()
                && Arrays.equals(getExamScores(), student.getExamScores())
                && Objects.equals(getSign(), student.getSign());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSign(), getId()) + Arrays.hashCode(getExamScores());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("examScores=").append(Arrays.toString(examScores));
        sb.append(", sign=").append(sign);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
