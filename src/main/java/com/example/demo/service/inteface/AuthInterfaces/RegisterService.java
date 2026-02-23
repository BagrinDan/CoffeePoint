package com.example.demo.service.inteface.AuthInterfaces;


import com.example.demo.model.dto.Request.auth.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<?> registerUser(SignUpRequest request);
}
