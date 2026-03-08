package com.example.demo.model.coffee;


public class Latte extends Beverage{
    @Override
    public double getPrice() {
        return 2.99;
    }

    @Override
    public String getDescription(){
        return "Latte";
    }

    @Override
    public String toString(){
        return "Latte";
    }

    @Override
    public Beverage cloneObject() {
        return new Latte();
    }

}
