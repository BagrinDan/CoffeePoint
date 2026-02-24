package com.example.demo.service.inteface.generic_interfaces;

import com.example.demo.model.dto.Request.service_request.CoffeeOrderRequest;

public interface CoffeeOrderService {
    double order(CoffeeOrderRequest orderRequest);
}
