package com.example.demo.model.snack.snack_type;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import lombok.Getter;

@Getter
public class ChocolateDonut extends Snack{
    protected String description = "Donut cu chocolata";

    @Override
    public double getPrice() {
        return 0.50;
    }
}
