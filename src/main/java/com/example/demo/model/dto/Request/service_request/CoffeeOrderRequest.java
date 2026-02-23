package com.example.demo.model.dto.Request.service_request;

import com.example.demo.model.enums.coffee_enums.CoffeeEnum;
import com.example.demo.model.enums.coffee_enums.CondimentEnum;
import lombok.Data;

import java.util.List;


@Data
public class CoffeeOrderRequest {
    // Coffee
    private CoffeeEnum coffeeType;

    // Condiment
    private List<CondimentEnum> condimentEnum;
    // Snack
}
