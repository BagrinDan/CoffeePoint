package com.example.demo.model.coffee.factory;

import com.example.demo.model.coffee.Americano;
import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.CoffeeEnum;
import org.springframework.stereotype.Component;

@Component
public class AmericanoFactory implements CoffeeFactory {

    @Override
    public CoffeeEnum type() {
        return CoffeeEnum.AMERICANO;
    }

    @Override
    public Beverage create() {
        return new Americano();
    }
}
