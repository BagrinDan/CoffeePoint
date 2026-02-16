package com.example.demo.controller.Coffee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class OrderPageController {

    @GetMapping("/order")
    public String orderPage() {
        return "private/order";
    }
}
