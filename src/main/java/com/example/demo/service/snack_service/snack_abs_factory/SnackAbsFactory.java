package com.example.demo.service.snack_service.snack_abs_factory;


import com.example.demo.model.enums.snack_enums.SnackEnum;
import com.example.demo.model.snack.packing_type.Packing;
import com.example.demo.model.snack.snack_type.Snack;

/**
 * Snack Abstract factory
 * ver 1.0
 */

public interface SnackAbsFactory {
    /**
     * Create snack
     * @return Snack
     */
    Snack createSnack();

    /**
     * Need to create and to pack snacks
     * @return Packing
     */
    Packing createPacking();

    /**
     * Get snack type
     * @return type
     */
    SnackEnum getType();
}
