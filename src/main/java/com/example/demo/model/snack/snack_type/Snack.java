package com.example.demo.model.snack.snack_type;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import lombok.Getter;

@Getter
public abstract class Snack {
    protected String description = "Unknown snack";
    public SnackEnum type;

    public abstract double getPrice();

    public String toString(){
        return getDescription();
    }
}
