package com.example.demo.model.coffee;


// factory method

import com.example.demo.model.coffee.factory.CoffeeFactory;
import com.example.demo.model.enums.CoffeeEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CoffeeFactoryImpl {
    private final Map<CoffeeEnum, CoffeeFactory> creators;

    public CoffeeFactoryImpl(List<CoffeeFactory> creatorList) {
        this.creators = creatorList.stream()
                .collect(Collectors.toMap(
                        CoffeeFactory::type,
                        creator -> creator
                ));
    }

    public Beverage createCoffee(CoffeeEnum type) {
        CoffeeFactory creator = creators.get(type);
        if (creator == null) {
            throw new IllegalArgumentException("[!] Error: Unknown coffee type: " + type);
        }
        return creator.create();
    }
}