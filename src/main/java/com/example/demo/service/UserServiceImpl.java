package com.example.demo.service;


import com.example.demo.model.dto.Request.SignUpRequest;
import com.example.demo.model.entity.User;
import com.example.demo.model.enums.Auth.Gender;
import com.example.demo.model.enums.Auth.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.inteface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User createUser(SignUpRequest signUpRequest, String encodedPassword){
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setUsername(signUpRequest.getUsername());
        user.setNormalizedUsername(signUpRequest.getUsername().toUpperCase());
        user.setPassword(encodedPassword);
        user.setGender(Gender.OTHER);
        user.setRole(Role.USER);
        user.setActive(true);
        user.setCreateDate(LocalDateTime.now());

        return user;
    }

    public User getUser(String username){
        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));
        return user;
    }

    public String getUsername(Principal principal){
        if(principal == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return principal.getName();
    }
}