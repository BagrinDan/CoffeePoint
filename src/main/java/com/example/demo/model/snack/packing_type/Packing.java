package com.example.demo.model.snack.packing_type;

import lombok.Getter;

@Getter
public abstract class Packing {
    protected String description = "Unknown packing";

    public abstract double getPrice();

    public String toString(){
        return getDescription();
    }
}
