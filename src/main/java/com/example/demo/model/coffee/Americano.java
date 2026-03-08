package com.example.demo.model.coffee;



public class Americano extends Beverage{
    @Override
    public double getPrice() {
        return 1.99;
    }

    @Override
    public String getDescription(){
        return "Americano";
    }

    @Override
    public String toString(){
        return "Americano";
    }

    @Override
    public Beverage cloneObject() {
        return new Americano();
    }
}
