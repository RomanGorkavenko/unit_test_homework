package ru.gb.unitTest.semSix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class CompareListsTest {

    /**
     * Поле {@link ByteArrayOutputStream}.
     */
    private ByteArrayOutputStream outputStream;

    /**
     * Константа типа {@link List<Integer>}.
     * Со среднем значением листа 2.
     */
    private static final List<Integer> LIST_AVERAGE_VALUE_2 =
            new ArrayList<>(List.of(2, 2, 2));

    /**
     * Константа типа {@link List<Integer>}.
     * Со среднем значением листа 3.
     */
    private static final List<Integer> LIST_AVERAGE_VALUE_3 =
            new ArrayList<>(List.of(3, 3, 3));

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void compareAverageValueInList_interactionOfClasses_successfully()
            throws ListIsEmptyException {
        AverageValue mockAverageValue = mock(AverageValue.class);
        CompareLists compareLists = new CompareLists(mockAverageValue,
                LIST_AVERAGE_VALUE_2, LIST_AVERAGE_VALUE_3);

        compareLists.compareAverageValueInList();

        doCallRealMethod().when(mockAverageValue)
                .averageValueList(LIST_AVERAGE_VALUE_2);

        double actual = mockAverageValue
                .averageValueList(LIST_AVERAGE_VALUE_2);

        double expected = 2.0;

        verify(mockAverageValue, times(2))
                .averageValueList(LIST_AVERAGE_VALUE_2);

        verify(mockAverageValue, times(1))
                .averageValueList(LIST_AVERAGE_VALUE_3);

        assertEquals(expected, actual);
    }

    @Test
    void compareAverageValueInList_secondListIsLargerFirst_printingResultToConsole()
            throws ListIsEmptyException {
        CompareLists compareLists = new CompareLists(new AverageValue(),
                LIST_AVERAGE_VALUE_2, LIST_AVERAGE_VALUE_3);
        String expected = "Второй список имеет большее среднее значение\r\n";

        compareLists.compareAverageValueInList();

        String actual = outputStream.toString();

        assertEquals(expected, actual);
    }

    @Test
    void compareAverageValueInList_firstListIsLargerSecond_printingResultToConsole()
            throws ListIsEmptyException {
        CompareLists compareLists = new CompareLists(new AverageValue(),
                LIST_AVERAGE_VALUE_3, LIST_AVERAGE_VALUE_2);
        String expected = "Первый список имеет большее среднее значение\r\n";

        compareLists.compareAverageValueInList();

        String actual = outputStream.toString();

        assertEquals(expected, actual);
    }

    @Test
    void compareAverageValueInList_averageValuesOfListsAreEqual_printingResultToConsole()
            throws ListIsEmptyException {
        CompareLists compareLists = new CompareLists(new AverageValue(),
                LIST_AVERAGE_VALUE_3, LIST_AVERAGE_VALUE_3);
        String expected = "Средние значения равны\r\n";

        compareLists.compareAverageValueInList();

        String actual = outputStream.toString();

        assertEquals(expected, actual);
    }
}
