package com.example.test.controller;

import com.example.test.model.Model;
import com.example.test.model.entity.Clicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Контроллер проекта
 * {@code createClickerInDB} создает Сущность Clicker в базу данных
 * {@code increment} Увеличивает поле counter на 1
 * {@code changeDataDB} Вносит изменения в базу данных
 */
@Component
public class Controller {
    private final Model model;

    @Autowired
    public Controller(Model model){
        this.model = model;
    }

    public void createClickerInDB(Clicker clicker) {
        model.create(clicker);
    }

    public Clicker increment(Clicker clicker) {
        return model.incrementCounter(clicker);
    }


    public String changeDataDB(Clicker clicker) {
        return model.changingCounterInDB(clicker);
    }

}
