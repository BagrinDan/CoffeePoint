package com.example.demo.model.dto.Response.order_response;

import com.example.demo.model.enums.coffee_enums.CondimentEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
public class ComboOrderResponse extends OrderResponse{
    private String coffee;
    private List<CondimentEnum> condimentList;
}
