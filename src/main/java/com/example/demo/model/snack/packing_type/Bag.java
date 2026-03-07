package com.example.demo.model.snack.packing_type;

import lombok.Getter;

@Getter
public class Bag extends Packing{
    protected String description = "Bag";

    @Override
    public double getPrice() {
        return 0.15;
    }
}
