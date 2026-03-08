package com.example.demo.model.dto.Response.order_response;

import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder
public class SnackProducerResponse {
    private Snack snack;
    private Packing packing;
}
