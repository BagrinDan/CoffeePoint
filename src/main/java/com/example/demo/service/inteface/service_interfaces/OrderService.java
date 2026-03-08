package com.example.demo.service.inteface.service_interfaces;

import com.example.demo.model.dto.Request.service_request.ComboOrderRequest;
import com.example.demo.model.dto.Response.order_response.ComboOrderResponse;

public interface OrderService {
    ComboOrderResponse createClone(ComboOrderRequest request);
}
