package com.example.demo.model.enums.Auth;
import lombok.Getter;



@Getter
public enum Gender {
    OTHER(0),
    MALE(1),
    FEMALE(2);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

}