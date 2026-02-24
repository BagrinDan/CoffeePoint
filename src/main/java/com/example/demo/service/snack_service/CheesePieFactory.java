package com.example.demo.service.snack_service;

import com.example.demo.model.snack.packing_type.Bag;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.CheesePie;
import com.example.demo.model.snack.snack_type.Snack;
import org.springframework.stereotype.Component;


@Component
public class CheesePieFactory implements SnackAbsFactory{
    @Override
    public Snack createSnack() {
        return new CheesePie();
    }

    @Override
    public Packing createPacking() {
        return new Bag();
    }
}
