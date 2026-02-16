package com.example.demo.controller.Auth;


import com.example.demo.model.dto.Request.SignInRequest;
import com.example.demo.model.dto.Request.SignUpRequest;
import com.example.demo.service.inteface.AuthInterfaces.AuthService;
import com.example.demo.service.inteface.AuthInterfaces.RegisterService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthApiController {
    private final AuthService authService;
    private final RegisterService registerService;

    @PostMapping("/signin")
    public String signIn(@Valid @ModelAttribute SignInRequest signInRequest, HttpServletResponse response){
        System.out.println("Auth");
        authService.authUser(signInRequest, response);
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute SignUpRequest signUpRequest){
        System.out.println("Register");
        registerService.registerUser(signUpRequest);
        return "redirect:/";
    }
}
