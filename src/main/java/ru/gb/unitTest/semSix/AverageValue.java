package ru.gb.unitTest.semSix;

import java.util.List;

/**
 * Класс реализует функцию вычисления среднего значения
 * в листе целых чисел.
 */
public class AverageValue {

    /**
     * Метод вычисления среднего значения в листе целых чисел.
     * @param list лист целых чисел
     * @return среднее значение листа
     * @throws ListIsEmptyException исключение при пустом значении листа.
     */
    public double averageValueList(final List<Integer> list)
            throws ListIsEmptyException {
        return list.stream()
                .mapToDouble(value -> value)
                .average()
                .orElseThrow(ListIsEmptyException::new);
    }

}
