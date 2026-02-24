package com.example.demo.service.snack_service;

import com.example.demo.model.dto.Response.snack_response.SnackOrderResponse;
import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SnackProducer {
    private final Map<SnackEnum, SnackAbsFactory> creators;

    public SnackProducer(List<SnackAbsFactory> factoryList){
        this.creators = factoryList.stream()
                .collect(Collectors.toMap(
                        creators -> creators.createSnack().getType(),
                        creators -> creators
                ));
    }

    public SnackOrderResponse createSnack(SnackEnum type){
        SnackAbsFactory factory = creators.get(type);

        if(factory == null){
            throw new IllegalArgumentException("[!] Unknown snack type: " + type);
        }

        Snack snack = factory.createSnack();
        Packing packing = factory.createPacking();

        return SnackOrderResponse.builder()
                .snack(snack.getDescription())
                .packing(packing.getDescription())
                .price(snack.getPrice() + packing.getPrice())
                .build();
    }
}
