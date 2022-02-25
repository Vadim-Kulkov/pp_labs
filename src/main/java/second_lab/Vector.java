package second_lab;

public class Vector {

    private final double[] cords;

    public Vector(double[] cords) {
        this.cords = cords;
    }

    public Vector(int length) {
        cords = new double[length];
    }

    /**
     * Доступ к элементам вектора
     */
    public double getByPosition(int position) {
        return cords[position];
    }

    public void setCordByPosition(int position, double newCord) {
        cords[position] = newCord;
    }

    /**
     * Получение «длины» вектора (количества его элементов)
     */
    public int getLengthOfVector() {
        return cords.length;
    }

    /**
     * Поиск минимального и максимального значений из элементов вектора
     */
    public double getMinFromCords() {
        sortCordsOfVector();
        return cords[0];
    }

    public double getMaxFromCords() {
        sortCordsOfVector();
        return cords[cords.length - 1];
    }

    /**
     * Сортировка вектора (по возрастанию или убыванию – на ваш выбор). Selection sort
     */
    public void sortCordsOfVector() {
        if (cords.length <= 1) {
            return;
        }
        int pos;
        double temp;
        for (int i = 0; i < cords.length; i++) {
            pos = i;
            for (int j = i + 1; j < cords.length; j++) {
                if (cords[j] < cords[pos]) {
                    pos = j;
                }
            }
            temp = cords[pos];
            cords[pos] = cords[i];
            cords[i] = temp;
        }
    }

    /**
     * Нахождение евклидовой нормы
     */
    public double findNorm() {
        double result = 0;
        for (int i = 0; i < cords.length; i++) {
            result += cords[i] * cords[i];
        }
        return Math.sqrt(result);
    }

    /**
     * Умножение вектора на число
     */
    public double[] multiplyByNumber(double multiplier) {
        for (int i = 0; i < cords.length; i++) {
            cords[i] *= multiplier;
        }
        return cords;
    }

    /**
     * Сложение двух векторов
     */
    public double[] sumOfVectors(double[] y) {
        if (y.length != cords.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < y.length; i++) {
            cords[i] += y[i];
        }
        return cords;
    }

    /**
     * Нахождение скалярного произведения двух векторов
     */
    public double[] scalarMultiplication(double[] y) {
        if (y.length != cords.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < y.length; i++) {
            cords[i] *= y[i];
        }
        return cords;
    }
}
