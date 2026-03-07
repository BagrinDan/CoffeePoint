package com.example.demo.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class OrderPageController {

    // Coffee
    @GetMapping("/coffee_order")
    public String coffeeOrderPage() {
        return "private/coffee_order";
    }

    @GetMapping("/coffee_order_success")
    public String coffeeOrderSuccessPage() {
        return "private/coffee_order_success";
    }

    // Snack
    @GetMapping("/snack_order")
    public String snackOrderPage() {
        return "private/snack_order";
    }

    @GetMapping("/snack_order_success")
    public String snackOrderSuccessPage(){
        return "private/snack_order_success";
    }
}
