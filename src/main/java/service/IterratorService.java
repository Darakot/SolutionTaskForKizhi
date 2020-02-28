package service;

import java.util.List;

public interface IterratorService {
    /**
     * Устанавливаем переменную
     * @param strCode - строка кода
     */
    void set(String strCode);

    /**
     * Вычитаем из переменной
     * @param strCode - строка кода
     */
    void sub (String strCode);

    /**
     * Выводим переменную в консоль
     * @param strCode - строка кода
     */
    void print(String strCode);

    /**
     * Вызываем функцию
     * @param strCode - строка кода
     * @return
     */
    List<Integer> call(String strCode);

//    /**
//     * Запускаем код
//     * @param strCode - строка кода
//     */
//    void run(String strCode);

    /**
     * Добавляет строчку кода
     * @param strCode - строка кода
     */
    void addStrCode(String strCode);


    /**
     * Забираем строчку кода
     */
    String getStrCode(Integer numLine);

    /**
     * Удаляет переменную
     * @param strCode - строка кода
     */
    void rem (String strCode);

    /**
     * @return - номер строки
     */
    Integer getLastLine ();
}
