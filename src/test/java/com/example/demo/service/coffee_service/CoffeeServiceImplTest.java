package com.example.demo.service.coffee_service;

import com.example.demo.model.coffee.Americano;
import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.dto.Request.service_request.CoffeeOrderRequest;
import com.example.demo.model.dto.Response.order_response.CoffeeOrderResponse;
import com.example.demo.model.enums.coffee_enums.CoffeeEnum;
import com.example.demo.model.enums.coffee_enums.CondimentEnum;
import com.example.demo.service.coffee_service.factory.CoffeeProducer;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Test coffee creation.
 * We can have coffee with no condiments, but number of condiments can't overreach 5
 */

@ExtendWith(MockitoExtension.class)
class CoffeeServiceImplTest {
    @Mock
    private CoffeeProducer producer;

    @Mock
    private Beverage beverage;

    @InjectMocks
    private CoffeeServiceImpl service;

    // Coffee without condiments
    @ParameterizedTest
    @EnumSource(CoffeeEnum.class)
    void shouldCreateCoffeeWithoutCondiments(CoffeeEnum type){
        System.out.println("--- Coffee without condiments ---");

        CoffeeOrderRequest request = new CoffeeOrderRequest();
        request.setCoffeeType(type);
        request.setCondimentEnum(null);

        Beverage beverage = mock(Beverage.class);
        when(producer.createCoffee(any())).thenReturn(beverage);
        when(beverage.getDescription()).thenReturn(type.name());
        when(beverage.getPrice()).thenReturn(1.99);

        CoffeeOrderResponse response = service.order(request);

        assertEquals(type.name(), response.getCoffee());
        assertEquals(1.99, response.getPrice());
        assertNull(response.getCondimentList());

        System.out.println("[!] Order created: " + response.getCoffee() + ". Price: " + response.getPrice() + "$, " + response.getCondimentList());
    }

    // Coffee with 1-5 condiments
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void shouldCreateCoffeeWithSeveralCondiments(int count){
        System.out.println("--- Coffee with 1-5 condiments ---");

        CoffeeOrderRequest request = new CoffeeOrderRequest();

        List<CondimentEnum> condimentList = new ArrayList<>();

        for(int i = 0; i < count; i++){
            condimentList.add(CondimentEnum.MILK);
        }

        request.setCoffeeType(CoffeeEnum.AMERICANO);
        request.setCondimentEnum(condimentList);

        Beverage beverage = mock(Beverage.class);

        when(producer.createCoffee(any())).thenReturn(beverage);
        when(beverage.getDescription()).thenReturn(CoffeeEnum.AMERICANO.name());
        when(beverage.getPrice()).thenReturn(1.99);

        CoffeeOrderResponse response = service.order(request);

        assertEquals(condimentList.size(), response.getCondimentList().size());
    }

    // Coffee with more as 5 condiments
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 10})
    void shouldThrowExceptionWhenCondimentsOverLimit(int count) {
        CoffeeOrderRequest request = new CoffeeOrderRequest();
        request.setCoffeeType(CoffeeEnum.AMERICANO);

        List<CondimentEnum> condimentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            condimentList.add(CondimentEnum.MILK);
        }

        request.setCondimentEnum(condimentList);

        assertThrows(IllegalArgumentException.class,
                () -> service.order(request));
    }
}