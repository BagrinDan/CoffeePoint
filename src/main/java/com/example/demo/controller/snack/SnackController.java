package com.example.demo.controller.snack;


import com.example.demo.model.dto.Request.service_request.SnackOrderRequest;
import com.example.demo.model.dto.Response.order_response.SnackOrderResponse;
import com.example.demo.service.inteface.service_interfaces.SnackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snack")
@AllArgsConstructor
public class SnackController {

    private final SnackService snackService;

    @PostMapping("/create_order")
    public String orderSnack(@ModelAttribute SnackOrderRequest request, Model model){
        SnackOrderResponse response = snackService.order(request);

        model.addAttribute("price", response.getPrice());
        model.addAttribute("snack", response.getSnack());
        model.addAttribute("packing", response.getPacking());

        return "private/snack_order_success";
    }

}
