package com.example.demo.menu;


import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.Espresso;
import com.example.demo.model.coffee.Latte;
import com.example.demo.model.dto.Request.service_request.ComboOrderRequest;
import com.example.demo.model.enums.combo_enums.ComboEnum;
import com.example.demo.service.coffee_service.component.Milk;
import com.example.demo.service.coffee_service.component.Sugar;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Singleton
@Component
public class SpecialMenu {

    private static SpecialMenu instance;
    private final Map<ComboEnum, Beverage> menu = new HashMap<>();

    private SpecialMenu() {
        initMenu();
    }

    /*
    public static SpecialMenu getInstance() {
        if (instance == null) {
            instance = new SpecialMenu();
        }
        return instance;
    }
     */

    private void initMenu() {
        // Student combo
        Beverage latte = new Latte();
        latte = new Sugar(latte);

        menu.put(ComboEnum.STUDENT, latte);

        // Employee combo
        Beverage espresso = new Espresso();
        espresso = new Milk(espresso);

        menu.put(ComboEnum.EMPLOYEE, espresso);
    }

    public Beverage getPrototype(ComboOrderRequest request) {
        Beverage base = menu.get(request.getComboType());
        if (base == null) return null;

        return base.cloneObject();
    }
}
