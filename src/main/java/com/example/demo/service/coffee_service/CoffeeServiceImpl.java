package com.example.demo.service.coffee_service;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.dto.Response.builder_order.CoffeeResponseBuilder;
import com.example.demo.model.dto.Response.order_response.CoffeeOrderResponse;
import com.example.demo.model.dto.Response.order_response.OrderResponse;
import com.example.demo.service.coffee_service.factory.CoffeeProducer;
import com.example.demo.model.dto.Request.service_request.CoffeeOrderRequest;
import com.example.demo.service.coffee_service.component.CondimentFactory;

import com.example.demo.model.enums.coffee_enums.CondimentEnum;

import com.example.demo.service.inteface.service_interfaces.CoffeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

/**
 * Coffee BL Service.
 * Creates coffee with condiments base on [Factory Method] and [Decorator].
 */


@Service
@AllArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    public final CoffeeProducer factory;

    // Create order
    public CoffeeOrderResponse order(CoffeeOrderRequest orderRequest){
        // Create beverage
        Beverage beverage = factory.createCoffee(orderRequest.getCoffeeType());
        List<CondimentEnum> condimentEnumList = orderRequest.getCondimentEnum();

        if(condimentEnumList != null && !condimentEnumList.isEmpty()){
            ListIterator<CondimentEnum> listIterator = condimentEnumList.listIterator();

            if(condimentEnumList.size() > 5){
                throw new IllegalArgumentException("[*] No more when 5 condiment");
            }

            // Decorate beverage with condiment/condiments
            while(listIterator.hasNext()){
                CondimentEnum condimentEnum = listIterator.next();
                beverage = CondimentFactory.addCondiment(beverage, condimentEnum);
            }
        }

        // TODO: Save in bd

        return new CoffeeResponseBuilder()
                .coffee(beverage.getDescription())
                .condimentList(condimentEnumList)
                .price(beverage.getPrice())
                .build();
    }

    // TODO: Get orders
    // TODO: Update order
    // TODO: Delete order

}
