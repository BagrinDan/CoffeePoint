package com.example.demo.model.coffee.component;
import com.example.demo.model.coffee.Beverage;


public class Sugar extends Condiment {
    public Sugar(Beverage beverage){
        super(beverage);
    }

    @Override
    public double getPrice() {
        return 0;
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
