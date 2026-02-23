package com.example.demo.controller.User;

import com.example.demo.service.inteface.service_interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {
    private final UserService userService;

    @GetMapping("/getUsername")
    public Map<String, String> getUsername(Principal principal){
        userService.getUsername(principal);

        return Collections.singletonMap("name", principal.getName());
    }
}
