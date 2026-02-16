package com.example.demo.controller.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class AuthPageController {

    @GetMapping("/auth")
    public String authPage(){
        return "public/auth";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "public/register";
    }
}
