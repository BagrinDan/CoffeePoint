package com.example.demo.service.inteface.service_interfaces;


import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.service.inteface.generic_interfaces.OrderService;

public interface SnackService extends OrderService<SnackOrderRequest, SnackOrderResponse> {
}
