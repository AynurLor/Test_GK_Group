package com.example.test.view;

import com.example.test.controller.Controller;
import com.example.test.model.entity.Clicker;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Создание представления для прилжения
 */
@Route("main")
public class MainView extends VerticalLayout {
    private final CounterEditor editor;
    private final Controller controller;
    private final Button button = new Button("+");
    private Clicker clicker = new Clicker(1,"0" );

    /**
     * Конструктор для
     * @param controller контроллер проекта
     * Создание таблицы в db h2
     * Иннициализация формы для ввода числа
     * Создание предстваления
     */
    @Autowired
    public MainView(Controller controller) {
        this.controller = controller;
        editor = new CounterEditor(controller, clicker);
        controller.createClickerInDB(clicker);
        createView();
    }

    public CounterEditor getEditor() {
        return editor;
    }

    /**
     * Создаие основного предстваления
     * с добавленем:
     * {@code button} - элемент кнопки,
     * {@code @editor} - формы для ввода текста;
     */
    private void createView() {

        button.addClickShortcut(Key.ENTER);
        button.setWidth("60px");
        button.setHeight("60px");
        button.isAutofocus();

        button.addClickListener(click -> {

            if (editor.getCounter().isEmpty()) {
                clicker.setCounter("0");
            }
                clicker = controller.increment(clicker);
                controller.changeDataDB(clicker);
                editor.getBinder().readBean(clicker);
        });

        add(
                new H1("Clicker"),
                new VerticalLayout(
                        editor,
                        button
                )
        );

    }
}
