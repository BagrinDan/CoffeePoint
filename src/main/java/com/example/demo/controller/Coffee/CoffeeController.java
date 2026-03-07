package com.example.demo.controller.Coffee;

import com.example.demo.model.dto.Request.service_request.CoffeeOrderRequest;
import com.example.demo.model.dto.Response.order_response.CoffeeOrderResponse;
import com.example.demo.model.dto.Response.order_response.OrderResponse;
import com.example.demo.service.inteface.service_interfaces.CoffeeService;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }

    // Order coffee
    @PostMapping("/create_order")
    public String createOrder(@ModelAttribute CoffeeOrderRequest orderRequest, Model model){
        CoffeeOrderResponse response = coffeeService.order(orderRequest);

        model.addAttribute("price", response.getPrice());
        model.addAttribute("order", response.getCoffee());

        return "private/coffee_order_success";
    }

    // TODO: Rest of controller functions

    @PostMapping("/get_order")
    public ResponseEntity<?> getOrder(@Valid @RequestBody CoffeeOrderRequest orderRequest){

        return ResponseEntity.ok("1");
    }

    @PostMapping("/update_order")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody CoffeeOrderRequest orderRequest){

        return ResponseEntity.ok("Order updated");
    }

    @PostMapping("/delete_order")
    public ResponseEntity<?> deleteOrder(@Valid @RequestBody CoffeeOrderRequest orderRequest){

        return ResponseEntity.ok("Order deleted");
    }
}
