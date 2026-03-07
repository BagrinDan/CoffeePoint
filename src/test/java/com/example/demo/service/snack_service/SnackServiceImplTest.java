package com.example.demo.service.snack_service;

import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.service.snack_service.snack_abs_factory.SnackProducer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test snack creation.
 * There is no complex business logic (for now at least), so we test properly creation of objects
 */

@ExtendWith(MockitoExtension.class)
class SnackServiceImplTest {

    @Mock
    private SnackProducer snackProducer;

    @InjectMocks
    private SnackServiceImpl service;

    @ParameterizedTest
    @EnumSource(SnackEnum.class)
    void shouldCreateSnackAndReturnResponse(SnackEnum type) {
        SnackOrderRequest request = new SnackOrderRequest();
        request.setSnackType(type);

        SnackOrderResponse mockResponse = new SnackOrderResponse();
        mockResponse.setSnack(type.name());
        mockResponse.setPrice(3.99);

        when(snackProducer.createOrder(type)).thenReturn(mockResponse);

        SnackOrderResponse response = service.order(request);

        assertEquals(type.name(), response.getSnack());
        assertEquals(3.99, response.getPrice());

        verify(snackProducer, times(1)).createOrder(type);

        System.out.println("[*] Snack:" + response.getSnack());
        System.out.println("[*] Pack:" + response.getPacking());
        System.out.println("[*] Price:" + response.getPrice());
    }
}