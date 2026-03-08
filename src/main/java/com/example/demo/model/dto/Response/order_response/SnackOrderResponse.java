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

        public Builder snack(String snack){
            this.snack = snack;
            return this;
        }

        public Builder packing(String packing){
            this.packing = packing;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public SnackOrderResponse build(){
            SnackOrderResponse response = new SnackOrderResponse();
            response.snack = this.snack;
            response.packing = this.packing;
            response.price = this.price;
            return response;
        }
    }
}
