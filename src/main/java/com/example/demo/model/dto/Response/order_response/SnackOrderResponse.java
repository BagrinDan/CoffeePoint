package com.example.demo.model.dto.Response.order_response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SnackOrderResponse extends OrderResponse{
    private String snack;
    private String packing;

    public static class Builder {
        private String snack;
        private String packing;
        private double price;


    }
}
