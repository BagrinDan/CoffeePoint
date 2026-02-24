package com.example.demo.model.dto.Response.snack_response;

import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SnackOrderResponse {
    private String snack;
    private String packing;
    private double price;

}
