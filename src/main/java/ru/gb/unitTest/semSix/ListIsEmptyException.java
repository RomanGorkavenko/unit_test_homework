package ru.gb.unitTest.semSix;

/**
 * Класс исключения для обработки пустого листа.
 * Расширяет {@link Exception}
 * наследуется от абстрактного класса {@link MyException}
 */
public class ListIsEmptyException extends MyException {

    /**
     * Конструктор.
     * Обращается к базовому классу {@link MyException}.
     * Передает сообщение родителю.
     */
    public ListIsEmptyException() {
        super("Невозможно посчитать среднее значение в пустом листе.");
    }
}
