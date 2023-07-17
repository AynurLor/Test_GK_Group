package com.example.test.model;

import com.example.test.model.dao.CounterRepository;
import com.example.test.model.entity.Clicker;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Бизнес логика проекта
 * {@code counterRepository} для взаимодейсвтия с базой данных
 */
@SpringComponent
public class Model {
    private final CounterRepository counterRepository;

    @Autowired
    public Model(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    /**
     * Созднаие таблицы для хранения counter
     * @param clicker сущность для подсчета кол-ва нажатий
     */
    public void create(Clicker clicker) {
        counterRepository.save(clicker);
    }


    /**
     * Метод для увеличения поле counter Clicker класса на 1
     * @param clicker сушность кол-во нажатий
     * @return инкрементированный экз. класса Clicker
     */
    public Clicker incrementCounter(Clicker clicker) {

        Integer number = convertStringToInteger(clicker);
        if (number >= Integer.MAX_VALUE)
            clicker.setCounter("0");
        else
            clicker.setCounter((++number).toString());
        return clicker;
    }

    /**
     * Метод для изминения кол-во нажатий в db
     * @param clicker сушность кол-во нажатий
     * @return "true" - если число обновилось успешно, "false" - имеются ошибки
     */
    public String changingCounterInDB(Clicker clicker) {

        String number = convertStringToInteger(clicker).toString();
        if (counterRepository.update(number) == 0)
            return "0";
        return number;
    }

    /**
     * Конвертация строки в число
     * @param clicker входная строка числа
     * @return число, либо 0 (если строка не валидна)
     */
    public Integer convertStringToInteger(Clicker clicker) {

        String result_line = clicker.getCounter();

        if (!stringIsValid(result_line))
            return 0;

        return Integer.parseInt(result_line);
    }

    /**
     * Провеорка строки на валидность
     * @param line входная строка с числом
     * @return "true" - если строка валидна, иначе "false"
     */
    private boolean stringIsValid(String line) {

        if (line.isEmpty())
            return false;

        try {
            Integer.valueOf(line);
        } catch (NumberFormatException e){
            System.err.println("Некорректный ввод: " + e.getMessage());
            return false;
        }

        return true;
    }

}
