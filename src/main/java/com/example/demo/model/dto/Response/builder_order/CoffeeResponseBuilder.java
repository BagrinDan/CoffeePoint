package com.example.demo.model.dto.Response.builder_order;

import com.example.demo.model.dto.Response.order_response.CoffeeOrderResponse;
import com.example.demo.model.enums.coffee_enums.CondimentEnum;

import java.util.List;

public class CoffeeResponseBuilder implements OrderBuilder{
    protected CoffeeOrderResponse response = new CoffeeOrderResponse();

    public CoffeeResponseBuilder coffee(String coffee) {
        response.setCoffee(coffee);
        return this;
    }

    public CoffeeResponseBuilder condimentList(List<CondimentEnum> condimentList) {
        response.setCondimentList(condimentList);
        return this;
    }

    public CoffeeResponseBuilder price(double price) {
        response.setPrice(price);
        return this;
    }

    public CoffeeOrderResponse build() {
        return this.response;
    }
}
