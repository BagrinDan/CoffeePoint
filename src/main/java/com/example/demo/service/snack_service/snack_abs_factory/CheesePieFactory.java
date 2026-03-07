package com.example.demo.service.snack_service.snack_abs_factory;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.model.snack.packing_type.Bag;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.CheesePie;
import com.example.demo.model.snack.snack_type.Snack;
import org.springframework.stereotype.Component;

/**
 * Cheese Pie factory.
 * Create cheese pie as Snack and Bag as Packing
 */

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

    @Override
    public SnackEnum getType() {
        return SnackEnum.CHEESEPIE;
    }
}
