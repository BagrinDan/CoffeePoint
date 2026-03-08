package com.example.demo.service.coffee_service.component;
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
    @Override
    public Beverage cloneObject() {
        return new Milk(this.beverage.cloneObject());
    }
}
