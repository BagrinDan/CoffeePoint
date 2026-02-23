package com.example.demo.model.dto.Request.auth;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private String confirmPassword;
}
