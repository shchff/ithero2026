package com.envelope.ithero2026.dto.auth;

import com.envelope.ithero2026.domain.Role;

public record AuthResponse(
        String message,
        Long userId,
        Role role
)
{
}