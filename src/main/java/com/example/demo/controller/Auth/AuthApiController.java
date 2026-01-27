package com.example.demo.controller.Auth;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {
//    private final AuthServiceImpl authService;
//
//    public AuthApiController(AuthServiceImpl authService){
//        this.authService = authService;
//    }
//
//    @PostMapping("/sighin")
//    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest signInRequest){
//        return ResponseEntity.ok("Hi");
//    }
//
//    @PostMapping("/signUp")
//    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest){
//        return ResponseEntity.ok("HI");
//    }
}
