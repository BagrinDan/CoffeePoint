package com.example.demo.model.dto.Response.builder_order;

import com.example.demo.model.dto.Response.order_response.CoffeeOrderResponse;
import com.example.demo.model.enums.coffee_enums.CondimentEnum;

import java.util.List;

public interface OrderBuilder {
    OrderBuilder coffee(String coffee);
    OrderBuilder condimentList(List<CondimentEnum> condiments);
    OrderBuilder price(double price);
    CoffeeOrderResponse build();
}


