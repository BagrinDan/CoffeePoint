package com.example.demo.service.snack_service;


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
     * Need create and to pack snacks
     * @return Packing
     */
    Packing createPacking();
}
