package com.example.demo.service.coffee_service.factory;

import com.example.demo.model.coffee.Americano;
import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.coffee_enums.CoffeeEnum;
import org.springframework.stereotype.Component;

@Component
public class AmericanoFactory implements CoffeeFactory {

    @Override
    public CoffeeEnum getType() {
        return CoffeeEnum.AMERICANO;
    }

    @Override
    public Beverage create() {
        return new Americano();
    }
}
