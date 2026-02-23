package com.example.demo.service.coffee_service.factory;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.coffee_enums.CoffeeEnum;

public interface CoffeeFactory {
    CoffeeEnum type();
    Beverage create();
}
