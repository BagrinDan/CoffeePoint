package com.example.demo.service.snack_service;

import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.snack_response.SnackOrderResponse;
import com.example.demo.service.inteface.service_interfaces.SnackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SnackServiceImpl implements SnackService {
    private final SnackProducer snackProducer;

    @Override
    public SnackOrderResponse order(SnackOrderRequest order) {
        SnackOrderResponse response = snackProducer.createSnack(order.getSnackType());

        System.out.println("[*] Snack:" + response.getSnack());
        System.out.println("[*] Snack:" + response.getPrice());

        return response;
    }
}
