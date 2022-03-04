package third_lab.entities;

import third_lab.exceptions.SpecialException;
import third_lab.exceptions.SpecialRuntimeException;
import third_lab.interfaces.Person;

import java.util.Arrays;
import java.util.Objects;

public class Entrant implements Person {

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
    public Entrant() {
    }

    /**
     * Конструктор с параметрами, позволяющий полностью инициализировать объект
     *
     */
    public Entrant(int[] examScores, String sign, int id) {
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
        Entrant entrant = (Entrant) o;
        return getId() == entrant.getId()
                && Arrays.equals(getExamScores(), entrant.getExamScores())
                && Objects.equals(getSign(), entrant.getSign());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSign(), getId()) + Arrays.hashCode(getExamScores());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entrant{");
        sb.append("examScores=").append(Arrays.toString(examScores));
        sb.append(", sign='").append(sign).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
