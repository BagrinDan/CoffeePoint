package com.example.demo.model.dto.Response.order_response;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class OrderResponse {
    protected double price;
}
