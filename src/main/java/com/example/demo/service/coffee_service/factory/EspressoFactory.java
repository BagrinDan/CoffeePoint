package com.example.demo.service.coffee_service.factory;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.Espresso;
import com.example.demo.model.enums.coffee_enums.CoffeeEnum;
import org.springframework.stereotype.Component;

@Component
public class EspressoFactory implements CoffeeFactory {

    @Override
    public CoffeeEnum type() {
        return CoffeeEnum.ESPRESSO;
    }

    @Override
    public Beverage create() {
        return new Espresso();
    }
}
