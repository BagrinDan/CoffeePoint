package com.example.demo.service;


import com.example.demo.model.dto.Request.auth.SignInRequest;
import com.example.demo.security.JwtCore;
import com.example.demo.service.inteface.AuthInterfaces.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor // Automated DI
public class AuthServiceImpl implements AuthService {
    private final JwtCore jwtCore;
    private final AuthenticationManager authenticationManager;

    // Auth Method
    public ResponseEntity<?> authUser(SignInRequest request, HttpServletResponse response){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String token = jwtCore.generateToken(auth);

            System.out.println("Token: " + token);

            Cookie cookie = new Cookie("jwt-token", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(false);
            cookie.setPath("/");
            cookie.setMaxAge(jwtCore.getLifeTime());

            response.addCookie(cookie);

            SecurityContextHolder.getContext().setAuthentication(auth);
            return ResponseEntity.ok().body("Welcome " + jwtCore.getNameFromJwt(token));

        } catch (BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username or password");
        }
    }
}
