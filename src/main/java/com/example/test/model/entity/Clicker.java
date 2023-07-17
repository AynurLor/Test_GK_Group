package com.example.test.model.entity;

import jakarta.persistence.*;

/**
 * Сущность Кликера для db
 * Имеет 2 поля: id, number
 * */
@Entity
@Table(name = "Clicker")
public class Clicker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "counter")
    private String counter;

    /**
     * Пустой конструктор
     * */
    public Clicker() {}
    /**
     * Конструктор с 1 параметром
     * @param counter Кол-во нажатий
     * */
    public Clicker(Integer id, String counter) {
        this.counter = counter;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Clicker{" +
                "counter=" + counter +
                '}';
    }

}
