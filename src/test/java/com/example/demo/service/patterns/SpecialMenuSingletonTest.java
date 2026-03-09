package com.example.demo.service.patterns;

import com.example.demo.menu.SpecialMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class SpecialMenuSingletonTest {

    @Test
    void singletonReturnsSameInstance() {

        SpecialMenu menu1 = SpecialMenu.getInstance();
        SpecialMenu menu2 = SpecialMenu.getInstance();

        assertSame(menu1, menu2);
    }
}