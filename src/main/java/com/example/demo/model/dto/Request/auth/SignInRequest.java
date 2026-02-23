package com.example.demo.model.dto.Request.auth;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
