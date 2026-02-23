package com.example.demo.service.inteface.service_interfaces;

import com.example.demo.model.dto.Request.auth.SignUpRequest;
import com.example.demo.model.entity.User;

import java.security.Principal;

public interface UserService {
    User createUser(SignUpRequest signUpRequest, String encodedPassword);
    User getUser(String username);
    String getUsername(Principal principal);
}
