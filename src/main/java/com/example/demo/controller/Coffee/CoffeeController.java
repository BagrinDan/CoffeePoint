package com.example.demo.controller.Coffee;

import com.example.demo.service.inteface.CoffeeInterface.CoffeeOrderService;
import org.springframework.ui.Model;
import com.example.demo.model.dto.Request.OrderRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/order")
public class CoffeeController {
    private final CoffeeOrderService coffeeService;

    public CoffeeController(CoffeeOrderService coffeeService){
        this.coffeeService = coffeeService;
    }

    // Order coffee
    @PostMapping("/create_order")
    public String createOrder(@ModelAttribute OrderRequest orderRequest, Model model){
        double price = coffeeService.order(orderRequest);

        model.addAttribute("price", price);

        return "public/order_success";
    }

    // TODO: Rest of controller functions

    @PostMapping("/get_order")
    public ResponseEntity<?> getOrder(@Valid @RequestBody OrderRequest orderRequest){

        return ResponseEntity.ok("1");
    }

    @PostMapping("/update_order")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody OrderRequest orderRequest){

        return ResponseEntity.ok("Order updated");
    }

    @PostMapping("/delete_order")
    public ResponseEntity<?> deleteOrder(@Valid @RequestBody OrderRequest orderRequest){

        return ResponseEntity.ok("Order deleted");
    }
}
