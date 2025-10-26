package com.achraf.security.controller;

import com.achraf.security.dto.AuthRequest;
import com.achraf.security.dto.AuthResponse;
import com.achraf.security.model.User;
import com.achraf.security.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse resp = authService.authenticate(request);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        authService.register(user);
        return ResponseEntity.ok("User registered");
    }
}
