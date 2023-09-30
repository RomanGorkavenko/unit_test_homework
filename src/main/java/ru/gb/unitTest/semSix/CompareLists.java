package ru.gb.unitTest.semSix;

import java.util.List;

/**
 * Класс для сравнения среднего значения листов целых чисел.
 */
public class CompareLists {

    /**
     * Первый лист.
     */
    private final List<Integer> first;

    /**
     * Второй лист.
     */
    private final List<Integer> second;

    /**
     * Связь с {@link AverageValue}.
     * Для вызова метода, вычисления среднего значения листа -
     * {@link AverageValue#averageValueList(List)}
     */
    private final AverageValue averageValue;

    /**
     * Конструктор.
     * @param first лист с целочисленными значениями.
     * @param second лист с целочисленными значениями.
     * @param averageValue объект класса {@link AverageValue}.
     */
    public CompareLists(final AverageValue averageValue,
                        final List<Integer> first,
                        final List<Integer> second) {
        this.first = first;
        this.second = second;
        this.averageValue = averageValue;
    }



    /**
     * Метод сравнения листов.
     * Вызывает метод {@link AverageValue#averageValueList(List)},
     * сначала для первого листа, затем для второго.
     * Присваивает эти значения в переменные.
     * Сравнивает значения переменных и выводит в консоль,
     * результат сравнения.
     * @throws ListIsEmptyException исключение при пустом значении листа.
     */
    public void compareAverageValueInList() throws ListIsEmptyException {
        double averageFirst = averageValue.averageValueList(first);
        double averageSecond = averageValue.averageValueList(second);
        if (averageFirst > averageSecond) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if (averageFirst == averageSecond) {
            System.out.println("Средние значения равны");
        } else {
            System.out.println("Второй список имеет большее среднее значение");
        }
    }
}
