package ru.gb.unitTest.semSix;

/**
 * Абстрактный класс исключений.
 * Расширяет {@link Exception}
 */
public abstract class MyException extends Exception {

    /**
     * Конструктор.
     * Обращается к базовому классу {@link Exception}
     * @param message сообщение генерируемое исключением.
     */
    public MyException(final String message) {
        super(message);
    }
}
