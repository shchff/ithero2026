package com.envelope.ithero2026.dto.auth;

import com.envelope.ithero2026.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        @NotBlank String name,
        @NotBlank String surname,
        @Email @NotBlank String email,
        @NotBlank String password,
        @NotNull Role role,
        String phone
)
{
}