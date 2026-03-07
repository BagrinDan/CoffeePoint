package com.example.demo.model.dto.Request.service_request;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class SnackOrderRequest extends OrderRequest{
    private SnackEnum snackType;
}
