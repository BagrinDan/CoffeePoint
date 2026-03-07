package com.example.demo.service.inteface.service_interfaces;

import com.example.demo.model.dto.Request.service_request.CoffeeOrderRequest;
import com.example.demo.model.dto.Response.order_response.CoffeeOrderResponse;
import com.example.demo.service.inteface.generic_interfaces.OrderService;

public interface CoffeeService extends OrderService <CoffeeOrderRequest, CoffeeOrderResponse>{
}
