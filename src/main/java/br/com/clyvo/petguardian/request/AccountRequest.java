package br.com.clyvo.petguardian.request;

import br.com.clyvo.petguardian.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountRequest(
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotNull Role role,
        @NotNull Boolean active
) {}