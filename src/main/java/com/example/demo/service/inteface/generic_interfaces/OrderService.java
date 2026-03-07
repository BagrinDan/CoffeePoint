package com.example.demo.service.inteface.generic_interfaces;

import com.example.demo.model.dto.Request.service_request.OrderRequest;
import com.example.demo.model.dto.Response.order_response.OrderResponse;

public interface OrderService <Request extends OrderRequest, Response extends OrderResponse>{
    Response order(Request orderRequest);
}
