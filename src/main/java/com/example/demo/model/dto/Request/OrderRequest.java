package com.example.demo.model.dto.Request;

import com.example.demo.model.enums.CoffeeEnum;
import com.example.demo.model.enums.CondimentEnum;
import lombok.Data;

import java.util.List;


@Data
public class OrderRequest {
    // Coffee
    private CoffeeEnum coffeeType;

    // Condiment
    private List<CondimentEnum> condimentEnum;
    // Snack
}
