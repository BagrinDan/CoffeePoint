package com.example.demo.model.dto.Response.order_response;


import com.example.demo.model.enums.coffee_enums.CondimentEnum;
import com.example.demo.service.coffee_service.component.Condiment;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CoffeeOrderResponse extends OrderResponse{
    private String coffee;
    private List<CondimentEnum> condimentList;

    public static class Builder {
        private String coffee;
        private List<CondimentEnum> condimentList;
        private double price;

        public Builder coffee(String coffee){
            this.coffee = coffee;
            return this;
        }

        public Builder condimentList(List<CondimentEnum> condimentList){
            this.condimentList = condimentList;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public CoffeeOrderResponse build() {
            CoffeeOrderResponse response = new CoffeeOrderResponse();
            response.coffee = this.coffee;
            response.condimentList = this.condimentList;
            response.price = this.price;
            return response;
        }

    }
}
