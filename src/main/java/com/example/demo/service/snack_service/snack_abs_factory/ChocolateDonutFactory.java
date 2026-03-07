package com.example.demo.service.snack_service.snack_abs_factory;

import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.model.snack.packing_type.Box;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.ChocolateDonut;
import com.example.demo.model.snack.snack_type.Snack;
import org.springframework.stereotype.Component;

/**
 * Chocolate Donut factory.
 * We create donut as Snack and box as Packing
 */

@Component
public class ChocolateDonutFactory implements SnackAbsFactory{
    @Override
    public Snack createSnack() {
        return new ChocolateDonut();
    }

    @Override
    public Packing createPacking() {
        return new Box();
    }

    @Override
    public SnackEnum getType() {
        return SnackEnum.CHOCOLATEDONUT;
    }
}
