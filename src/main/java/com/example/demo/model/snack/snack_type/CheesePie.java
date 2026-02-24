package com.example.demo.model.snack.snack_type;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import lombok.Getter;

@Getter
public class CheesePie extends Snack{
    protected String description = "CheesePie";

    @Override
    public SnackEnum getType() {
        return SnackEnum.CHEESEPIE;
    }

    @Override
    public double getPrice() {
        return 0.99;
    }
}
