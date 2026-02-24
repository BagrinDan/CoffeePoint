package com.example.demo.model.snack.packing_type;


import lombok.Getter;

@Getter
public class Box extends Packing{
    protected String description = "Box";

    @Override
    public double getPrice() {
        return 0.15;
    }
}
