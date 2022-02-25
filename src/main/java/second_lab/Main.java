package second_lab;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[] cords = new double[]{0.22, 2.2, 99.1, 0.1, 15, 12};
        Vector firstVector = new Vector(cords);
        for (double i : cords) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Сортировка");
        firstVector.sortCordsOfVector();
        for (double i : cords) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.print("Норма: ");
        System.out.println(firstVector.findNorm());

        System.out.print("Длинна вектора: ");
        System.out.println(firstVector.getLengthOfVector());

        System.out.print("Получение по позиции 2: ");
        System.out.println(firstVector.getByPosition(2));

        System.out.println("Сумма векторов: ");
        System.out.println(Arrays.toString(firstVector.sumOfVectors(new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5})));

        System.out.println("Максимальное значение: ");
        System.out.println(firstVector.getMaxFromCords());

        System.out.println("Минимальное значение: ");
        System.out.println(firstVector.getMinFromCords());

        System.out.println("Умножить на число 5.1: ");
        System.out.println((Arrays.toString(firstVector.multiplyByNumber(5.1))));

        System.out.println("Скалярное произведение на {10.1, 10.2, 10.3, 10.4, 10.5, 10.6}:");
        System.out.print(Arrays.toString(firstVector.scalarMultiplication(
                new double[] {10.1, 10.2, 10.3, 10.4, 10.5, 10.6})));
    }
}
