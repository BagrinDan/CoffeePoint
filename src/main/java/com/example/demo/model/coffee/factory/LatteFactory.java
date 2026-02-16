package com.example.demo.model.coffee.factory;


import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.Latte;
import com.example.demo.model.enums.CoffeeEnum;
import org.springframework.stereotype.Component;

@Component
public class LatteFactory implements CoffeeFactory {

    @Override
    public CoffeeEnum type() {
        return CoffeeEnum.LATTE;
    }

    @Override
    public Beverage create() {
        return new Latte();
    }
}
