package com.example.demo.controller.menu;


import com.example.demo.model.coffee.Beverage;
import com.example.demo.model.dto.Request.service_request.ComboOrderRequest;
import com.example.demo.model.dto.Response.order_response.ComboOrderResponse;
import com.example.demo.service.inteface.service_interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
@AllArgsConstructor
public class MenuApiController {
    private final OrderService orderService;

    @PostMapping("/combo_order")
    public String comboOrder(@ModelAttribute ComboOrderRequest request, Model model){
        ComboOrderResponse response = orderService.createClone(request);

        model.addAttribute("price", response.getPrice());
        model.addAttribute("order", response.getCoffee());

        return "private/coffee_order_success";

    }

}
