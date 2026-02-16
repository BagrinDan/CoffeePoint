package com.example.demo.service.inteface;

import com.example.demo.model.dto.Request.SignUpRequest;
import com.example.demo.model.entity.User;

import java.security.Principal;

public interface UserService {
    User createUser(SignUpRequest signUpRequest, String encodedPassword);
    User getUser(String username);
    String getUsername(Principal principal);
}
