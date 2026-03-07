package com.example.demo.service.snack_service;

import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.service.inteface.service_interfaces.SnackService;
import com.example.demo.service.snack_service.snack_abs_factory.SnackProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SnackServiceImpl implements SnackService {
    private final SnackProducer snackProducer;

    @Override
    public SnackOrderResponse order(SnackOrderRequest order) {
        // Some BL logic in future
        return snackProducer.createOrder(order.getSnackType());
    }

    // TODO: rest of CRUD operations
}
