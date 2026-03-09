package com.example.demo.service.patterns;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.BeveragePrototype;
import com.example.demo.model.coffee.Latte;
import com.example.demo.service.coffee_service.component.Sugar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeveragePrototypeCheck {
    @Test
    void prototypeCreatesCorrectCopy() {

        BeveragePrototype prototype =
                new BeveragePrototype(() -> new Sugar(new Latte()));

        Beverage first = prototype.cloneObject();
        Beverage second = prototype.cloneObject();

        assertNotSame(first, second);

        assertEquals(first.getPrice(), second.getPrice());
        assertEquals(first.getDescription(), second.getDescription());

        assertInstanceOf(Sugar.class, first);
        assertInstanceOf(Sugar.class, second);
    }
}
