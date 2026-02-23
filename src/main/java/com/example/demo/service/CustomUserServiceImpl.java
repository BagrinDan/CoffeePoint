package com.example.demo.service;


import com.example.demo.model.entity.User;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.service.inteface.service_interfaces.UserService;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserServiceImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUser(username);

        return UserDetailsImpl.build(user);
    }
}