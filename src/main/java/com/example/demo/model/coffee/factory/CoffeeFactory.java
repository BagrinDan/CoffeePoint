package com.example.demo.model.coffee.factory;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.CoffeeEnum;

public interface CoffeeFactory {
    CoffeeEnum type();
    Beverage create();
}
