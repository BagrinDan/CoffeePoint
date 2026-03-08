package com.example.demo.controller.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class MenuPageController {

    @GetMapping("/menu")
    public String menu(){
        return "/public/menu";
    }

    @GetMapping("/special_menu")
    public String specialMenu(){
        return "/public/special_menu";
    }
}
