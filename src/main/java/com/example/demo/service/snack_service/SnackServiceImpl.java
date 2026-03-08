package com.example.demo.service.snack_service;

import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.model.dto.Response.order_response.SnackProducerResponse;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;
import com.example.demo.service.inteface.service_interfaces.SnackService;
import com.example.demo.service.snack_service.snack_abs_factory.SnackProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class SnackServiceImpl implements SnackService {
    private final SnackProducer snackProducer;

    @Override
    public SnackOrderResponse order(SnackOrderRequest order) {
        // TODO: Some BL logic in future

        SnackProducerResponse producerResponse = snackProducer.createObjects(order.getSnackType());

        Snack snack = producerResponse.getSnack();
        Packing packing = producerResponse.getPacking();

        return new SnackOrderResponse.Builder()
                .snack(snack.getDescription())
                .packing(packing.getDescription())
                .price(snack.getPrice() + packing.getPrice())
                .build();
    }

    // TODO: rest of CRUD operations
}
