package com.example.demo.model.coffee;
import lombok.Getter;


@Getter
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public abstract double getPrice();

    public String toString(){
        return getDescription();
    }
}
