package com.example.demo.service.snack_service.snack_abs_factory;

import com.example.demo.model.dto.Response.order_response.OrderResponse;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.model.dto.Response.order_response.SnackProducerResponse;
import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Snack producer.
 * Creates snack and packing type that suits this snack.
 */

@Component
public class SnackProducer {
    private final Map<SnackEnum, SnackAbsFactory> creators;

    public SnackProducer(List<SnackAbsFactory> factoryList){
        this.creators = factoryList.stream()
                .collect(Collectors.toMap(
                        SnackAbsFactory::getType, // Was 'creators -> creators.createSnack().getType()'
                        creators -> creators
                ));
    }

    public SnackProducerResponse createObjects(SnackEnum type){
        SnackAbsFactory factory = creators.get(type);

        if(factory == null){
            throw new IllegalArgumentException("[!] Unknown snack type: " + type);
        }

        Snack snack = factory.createSnack();
        Packing packing = factory.createPacking();

        return SnackProducerResponse.builder()
                .snack(snack)
                .packing(packing)
                .build();
    }
}
