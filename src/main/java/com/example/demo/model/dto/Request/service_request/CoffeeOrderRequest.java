package com.example.demo.model.dto.Request.service_request;

import com.example.demo.model.enums.coffee_enums.CoffeeEnum;
import com.example.demo.model.enums.coffee_enums.CondimentEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Coffee order request.
 * DTO that stores user's coffee order
 */


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class CoffeeOrderRequest extends OrderRequest{
    // Coffee
    private CoffeeEnum coffeeType;

    // Condiment
    private List<CondimentEnum> condimentEnum;
}
