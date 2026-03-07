package com.example.demo.service.coffee_service.factory;


// factory method

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.enums.coffee_enums.CoffeeEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CoffeeProducer {
    private final Map<CoffeeEnum, CoffeeFactory> creators;

    public CoffeeProducer(List<CoffeeFactory> creatorList) {
        this.creators = creatorList.stream()
                .collect(Collectors.toMap(
                        CoffeeFactory::getType,
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