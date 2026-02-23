package com.example.demo.controller.snack;


import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snack")
public class SnackController {

    @PostMapping("/create_order")
    public String createOrder(@Valid @ModelAttribute SnackOrderRequest order, Model model){
        System.out.println("Snack");

        return "private/order_success";
    }

}
