package com.example.demo.model.coffee;
import lombok.Getter;


@Getter
public abstract class Beverage implements Prototype{
    protected String description = "Unknown Beverage";

    public abstract double getPrice();

    public String toString(){
        return getDescription();
    }

    @Override
    public abstract Beverage cloneObject();
}
