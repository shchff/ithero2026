package com.envelope.ithero2026.service;

import com.envelope.ithero2026.domain.Role;
import com.envelope.ithero2026.domain.User;
import com.envelope.ithero2026.dto.auth.AuthResponse;
import com.envelope.ithero2026.dto.auth.LoginRequest;
import com.envelope.ithero2026.dto.auth.RegisterRequest;
import com.envelope.ithero2026.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request)
    {
        if (userRepository.existsByEmail(request.email()))
        {
            throw new IllegalArgumentException("Email уже зарегистрирован");
        }

        User user = new User();
        user.setName(request.name());
        user.setSurname(request.surname());
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setRole(request.role() != null ? request.role() : Role.INSPECTOR);
        user.setPhone(request.phone());

        userRepository.save(user);
        return new AuthResponse("Регистрация успешна", user.getId(), user.getRole());
    }

    public AuthResponse login(LoginRequest request)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(request.email()).orElseThrow();
        return new AuthResponse("Вход выполнен", user.getId(), user.getRole());
    }
}