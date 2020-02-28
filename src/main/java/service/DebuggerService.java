package service;

import java.util.List;

public interface DebuggerService {

    /**
     * @param line - добавить точку останова на линию line
     */
    void addBreak(String strCode);

    /**
     * перейти к следующей линии без входа в функцию
     */
    void stepOver();

    /**
     * перейти на следующую исполняемую линию
     */
    void step();

    /**
     * вывести все переменные
     *
     * @return - возвращает все переменные(List)
     */
    List<String> printMem();

    /**
     * вывести стектрейс
     *
     * @return - выводит весь стектрейс(List)
     */
    String printTrace(String strCode);

    /**
     * исполнить программу до следующей точки останова
     */
    void run();


}
