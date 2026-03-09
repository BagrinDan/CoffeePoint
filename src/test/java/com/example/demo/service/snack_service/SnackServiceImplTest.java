package com.example.demo.service.snack_service;

import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.model.dto.Response.order_response.SnackProducerResponse;
import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;
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
 * There is no complex business logic (for now at least), so we test objects creation
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

        Snack snack = mock(Snack.class);
        Packing packing = mock(Packing.class);

        when(snack.getDescription()).thenReturn("Test snack");
        when(snack.getPrice()).thenReturn(5.0);

        when(packing.getDescription()).thenReturn("Test packing");
        when(packing.getPrice()).thenReturn(2.0);

        SnackProducerResponse producerResponse =
                new SnackProducerResponse(snack, packing);

        when(snackProducer.createObjects(type))
                .thenReturn(producerResponse);

        SnackOrderResponse response = service.order(request);

        assertNotNull(response);
        assertEquals("Test snack", response.getSnack());
        assertEquals("Test packing", response.getPacking());
        assertEquals(7.0, response.getPrice());

        verify(snackProducer).createObjects(type);
    }
}