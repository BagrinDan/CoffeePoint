package com.example.demo.model.dto.Response.order_response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class SnackOrderResponse extends OrderResponse{
    private String snack;
    private String packing;
}
