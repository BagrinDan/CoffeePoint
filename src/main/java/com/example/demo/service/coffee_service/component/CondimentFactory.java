package com.example.demo.service.coffee_service.component;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.coffee_enums.CondimentEnum;
import org.springframework.stereotype.Component;

@Component
public class CondimentFactory {
    public static Beverage addCondiment(Beverage beverage, CondimentEnum condiment){
        return switch (condiment){
            case MILK -> new Milk(beverage);
            case SUGAR -> new Sugar(beverage);
        };
    }
}
