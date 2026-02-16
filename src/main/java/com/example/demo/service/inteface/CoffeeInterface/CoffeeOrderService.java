package com.example.demo.service.inteface.CoffeeInterface;

import com.example.demo.model.dto.Request.OrderRequest;

public interface CoffeeOrderService {
    double order(OrderRequest orderRequest);
}
