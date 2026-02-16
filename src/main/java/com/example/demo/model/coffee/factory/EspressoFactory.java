package com.example.demo.model.coffee.factory;

import com.example.demo.model.coffee.Americano;
import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.Espresso;
import com.example.demo.model.enums.CoffeeEnum;
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
