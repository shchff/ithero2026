package com.envelope.ithero2026.controller;

import com.envelope.ithero2026.dto.auth.AuthResponse;
import com.envelope.ithero2026.dto.auth.LoginRequest;
import com.envelope.ithero2026.dto.auth.RegisterRequest;
import com.envelope.ithero2026.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.envelope.ithero2026.controller.ControllerNames.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController
{
    private final AuthService service;

    @PostMapping(REGISTER)
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(service.login(request));
    }
}