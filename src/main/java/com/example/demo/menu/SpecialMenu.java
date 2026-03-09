package com.example.demo.menu;


import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.BeveragePrototype;
import com.example.demo.model.coffee.Espresso;
import com.example.demo.model.coffee.Latte;
import com.example.demo.model.dto.Request.service_request.ComboOrderRequest;
import com.example.demo.model.enums.combo_enums.ComboEnum;
import com.example.demo.service.coffee_service.component.Milk;
import com.example.demo.service.coffee_service.component.Sugar;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



// Singleton
@Component
public class SpecialMenu {

    private final Map<ComboEnum, BeveragePrototype> menu = new HashMap<>();

    /*

        We didn't use 'getInstance() and private in constructor',
        because Spring creates a single bean instance for this component by default (singleton scope) via annotation @Component

    * */

    public SpecialMenu() {
        initMenu();
    }

    // This could also be implemented using a Factory Method,
    // but here it is intentionally kept simple to demonstrate the Prototype pattern
    private void initMenu() {
        // Student combo
        menu.put(ComboEnum.STUDENT, new BeveragePrototype(() -> {
            Beverage latte = new Latte();
            return new Sugar(latte); // Latte + Sugar
        }));

        // Employee combo
        menu.put(ComboEnum.EMPLOYEE, new BeveragePrototype(() -> {
            Beverage espresso = new Espresso();
            return new Milk(espresso); // Espresso + Milk
        }));
    }

    public Beverage getPrototype(ComboOrderRequest request) {
        if (request == null) {
            return null;
        }

        BeveragePrototype prototype = menu.get(request.getComboType());
        return prototype != null ? prototype.cloneObject() : null;
    }
}
