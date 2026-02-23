package com.example.demo.service.coffee_service.component;
import com.example.demo.model.coffee.Beverage;


public abstract class Condiment extends Beverage{
    protected String description;
    protected Beverage beverage;

    public Condiment(Beverage beverage){
        this.beverage = beverage;
    }
}
