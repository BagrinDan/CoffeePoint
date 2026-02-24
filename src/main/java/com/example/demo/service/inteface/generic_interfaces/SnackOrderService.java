package com.example.demo.service.inteface.generic_interfaces;

import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.snack_response.SnackOrderResponse;

public interface SnackOrderService {
    SnackOrderResponse order(SnackOrderRequest orderRequest);
}
