package com.example.demo.model.coffee.component;
import com.example.demo.model.coffee.Beverage;


public class Milk extends Condiment{
    public Milk(Beverage beverage){
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 0.25;
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + ", " + "Milk" ;
    }

    @Override
    public String toString(){
        return getDescription();
    }
}
