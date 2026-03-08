package com.example.demo.service;

import com.example.demo.menu.SpecialMenu;
import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.dto.Request.service_request.ComboOrderRequest;
import com.example.demo.model.dto.Response.order_response.ComboOrderResponse;
import com.example.demo.service.inteface.service_interfaces.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final SpecialMenu specialMenu;

    public OrderServiceImpl(SpecialMenu specialMenu) {
        this.specialMenu = specialMenu;
    }

    public Beverage orderDrink(ComboOrderRequest request) {

        Beverage prototype = specialMenu.getPrototype(request);

        return prototype.cloneObject();
    }

    public ComboOrderResponse createClone(ComboOrderRequest request){
        Beverage prototype = this.orderDrink(request);

        return ComboOrderResponse.builder()
                .coffee(prototype.getDescription())
                .price(prototype.getPrice())
                .build();
    }
}
