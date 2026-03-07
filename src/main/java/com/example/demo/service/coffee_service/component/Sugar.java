package com.example.demo.service.coffee_service.component;
import com.example.demo.model.coffee.Beverage;


public class Sugar extends Condiment {
    public Sugar(Beverage beverage){
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.15;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", " + "Sugar" ;
    }

    @Override
    public String toString(){
        return getDescription();
    }
}
