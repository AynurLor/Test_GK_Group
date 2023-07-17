package com.example.test.view;

import com.example.test.controller.Controller;
import com.example.test.model.entity.Clicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

/**
 * Класс для создания, позиционирования и взаимодействия с текстовым полем ввода
 */
public class CounterEditor extends FormLayout {

    private final Binder<Clicker> binder;
    private final TextField counter = new TextField("Write integer number");

    public CounterEditor(Controller controller, Clicker clicker) {
        binder = new Binder<>(Clicker.class);

        counter.setHelperText("Min -2147483648, Max 2147483647");
        counter.setWidth("90px");
        counter.setHeight("90px");
        counter.setValue("0");
        counter.setPattern("^-?\\d+$");
        counter.setMaxLength(11);
        counter.setErrorMessage("Please enter a valid integer number!");

        binder.bind(counter, Clicker::getCounter, Clicker::setCounter);

        counter.addValueChangeListener(event -> {
            clicker.setCounter(counter.getValue());
            String count = controller.changeDataDB(clicker);
            clicker.setCounter(count);
            counter.setValue(count);
        });

        add(counter);
    }

    public Binder<Clicker> getBinder() {
        return binder;
    }

    public TextField getCounter() {
        return counter;
    }

}

