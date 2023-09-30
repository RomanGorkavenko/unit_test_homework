package ru.gb.unitTest.semSix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AverageValueTest {

    /**
     * Константа для ожидаемого среднего значения списка.
     */
    private static final double EXPECTED_AVERAGE_VALUE = 2.0;

    /**
     * Поле {@link AverageValue}.
     * Для вызова метода, вычисления среднего значения листа -
     * {@link AverageValue#averageValueList(List)}
     */
    private AverageValue averageValue;
    @BeforeEach
    void setUp() {
        averageValue = new AverageValue();
    }

    @Test
    void averageValueList_averageValueIntegerList_successfully()
            throws ListIsEmptyException {

        double actual = averageValue.averageValueList(List.of(2, 2, 2));

        assertEquals(EXPECTED_AVERAGE_VALUE, actual);
    }

    @Test
    void averageValueList_giveAnEmptyListToMethod_throwsListIsEmptyException() {
        String expected =
                "Невозможно посчитать среднее значение в пустом листе.";

        String actual = assertThrows(ListIsEmptyException.class,
                () -> averageValue.averageValueList(List.of()))
                .getMessage();

        assertEquals(expected, actual);
    }
}
