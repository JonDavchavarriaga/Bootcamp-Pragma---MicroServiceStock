package com.microservicestock.infrastructure.Auth.rest;

import com.microservicestock.application.Jwt.AuthResponse;
import com.microservicestock.application.Jwt.AuthService;
import com.microservicestock.application.Jwt.LoginRequest;
import com.microservicestock.application.Jwt.RegisterRequest;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@PermitAll
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}

