package com.example.demo.service.inteface.generic_interfaces;

import com.example.demo.model.dto.Response.snack_response.SnackOrderResponse;

public interface SnackPriceService {
    double getPrice(SnackOrderResponse response);
}
