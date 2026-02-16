package com.example.demo.model.coffee.component;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.CondimentEnum;

public class CondimentFactory {
    public static Beverage addCondiment(Beverage beverage, CondimentEnum condiment){
        return switch (condiment){
            case MILK -> new Milk(beverage);
            case SUGAR -> new Sugar(beverage);
        };
    }
}
