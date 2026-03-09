package com.example.demo.model.coffee;

@FunctionalInterface
public interface PrototypeSupplier {
    Beverage get();
}