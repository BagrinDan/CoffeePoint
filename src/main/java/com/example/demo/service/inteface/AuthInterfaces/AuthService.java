package com.example.demo.service.inteface.AuthInterfaces;


import com.example.demo.model.dto.Request.SignInRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authUser(SignInRequest request, HttpServletResponse response);
}


