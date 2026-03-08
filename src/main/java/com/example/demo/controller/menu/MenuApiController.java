package com.example.demo.controller.menu;


import com.example.demo.model.dto.Request.service_request.ComboOrderRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class MenuApiController {

    @PostMapping("/combo_order")
    public String comboOrder(@ModelAttribute ComboOrderRequest request){
        System.out.println("[*] Hooo boy" + request);
        return "redirect:/";
    }
}
