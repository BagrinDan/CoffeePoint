package com.example.demo.service.coffee_service;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.service.coffee_service.factory.CoffeeProducer;
import com.example.demo.model.dto.Request.service_request.CoffeeOrderRequest;
import com.example.demo.service.coffee_service.component.CondimentFactory;

import com.example.demo.model.enums.coffee_enums.CondimentEnum;

import com.example.demo.service.inteface.service_interfaces.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;


@Service
public class CoffeeServiceImpl implements CoffeeService {

    public final CoffeeProducer factory;

    public CoffeeServiceImpl(CoffeeProducer factory){
        this.factory = factory;
    }

    // Create order
    public double order(CoffeeOrderRequest orderRequest){

        // Create beverage
        Beverage beverage = factory.createCoffee(orderRequest.getCoffeeType()); // AMERICANO
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

        // Console check
        System.out.println("[!] Order created: " + beverage + ". Price: " + beverage.getPrice() + "$");

        return getPrice(beverage);
    }


    public double getPrice(Beverage beverage){
        return beverage.getPrice();
    }
    // TODO: Get orders
    // TODO: Update order
    // TODO: Delete order
}
