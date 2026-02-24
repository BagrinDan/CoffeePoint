package com.example.demo.model.dto.Request.service_request;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import lombok.Data;

@Data
public class SnackOrderRequest {
    private SnackEnum snackType;
}
