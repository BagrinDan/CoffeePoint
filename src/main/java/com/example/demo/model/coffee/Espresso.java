package com.example.demo.model.coffee;


public class Espresso extends Beverage {
    @Override
    public double getPrice() {
        return 0.99;
    }

    @Override
    public String getDescription(){
        return "Espresso";
    }

    @Override
    public String toString(){
        return "Espresso";
    }
}
