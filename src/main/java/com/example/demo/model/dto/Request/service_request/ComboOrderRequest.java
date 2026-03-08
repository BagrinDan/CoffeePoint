package com.example.demo.model.dto.Request.service_request;

import com.example.demo.model.enums.combo_enums.ComboEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ComboOrderRequest extends OrderRequest{
    private ComboEnum comboType;
}
