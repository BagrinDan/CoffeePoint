package com.example.demo.service;

import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.coffee.CoffeeFactoryImpl;
import com.example.demo.model.coffee.component.CondimentFactory;

import com.example.demo.model.dto.Request.OrderRequest;
import com.example.demo.model.enums.CondimentEnum;

import com.example.demo.service.inteface.CoffeeInterface.CoffeeOrderService;
import com.example.demo.service.inteface.CoffeeInterface.СoffeePriceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;


@Service
public class CoffeeServiceImpl implements CoffeeOrderService, СoffeePriceService {

    public final CoffeeFactoryImpl factory;

    public CoffeeServiceImpl(CoffeeFactoryImpl factory){
        this.factory = factory;
    }

    // Create order
    public double order(OrderRequest orderRequest){

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
