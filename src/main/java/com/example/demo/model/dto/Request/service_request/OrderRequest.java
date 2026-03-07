package com.example.demo.model.dto.Request.service_request;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Primary order request DTO.
 * Need to use one method in OrderService.
 * Because we have 2 types of order: Coffee and Snack, we can use abstract object as [OrderRequest] for common method creation
 */

@Data
@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class OrderRequest  {
    protected int quantity;
}
