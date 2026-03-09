package com.example.demo.model.coffee;

public class BeveragePrototype implements Prototype {

    private final PrototypeSupplier supplier;

    public BeveragePrototype(PrototypeSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public Beverage cloneObject() {
        return supplier.get();
    }
}