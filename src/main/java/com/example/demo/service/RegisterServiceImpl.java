package com.example.demo.service;

import com.example.demo.model.dto.Request.auth.SignUpRequest;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.inteface.AuthInterfaces.RegisterService;
import com.example.demo.service.inteface.service_interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    // Register Method
    public ResponseEntity<?> registerUser(SignUpRequest request){
        // Verify if username exists
        if(userRepository.existsUserByUsername(request.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Choose different username. ");
        }

        // Verify if password is valid
        if(!isValid(request.getPassword())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Password is weak asf.");
        }

        // Verify if password equals confirmPassword
        if((!request.getPassword().equals(request.getConfirmPassword()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Password is not same as confirm password");
        }

        String encodingPassword = passwordEncoder.encode(request.getPassword());
        User user = userService.createUser(request, encodingPassword);

        userRepository.save(user);

        return ResponseEntity.ok("Success");
    }


    public boolean isValid(String password) {
        if (password == null) return false;

        boolean length = password.length() >= 8;
        boolean upper = password.chars().anyMatch(Character::isUpperCase);
        boolean lower = password.chars().anyMatch(Character::isLowerCase);
        boolean digit = password.chars().anyMatch(Character::isDigit);
        boolean special = password.matches(".*[!@#$%^&*()_+\\-\\[\\]}|;:'\",.<>/?].*");

        return length && upper && lower && digit && special;
    }
}
