package com.example.demo.service.patterns;

import com.example.demo.menu.SpecialMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertSame;

class SpecialMenuSingletonTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void singletonBeanShouldBeSameInstance() {

        SpecialMenu menu1 = context.getBean(SpecialMenu.class);
        SpecialMenu menu2 = context.getBean(SpecialMenu.class);

        assertSame(menu1, menu2);
    }
}