package br.com.clyvo.petguardian.dto.request;

import br.com.clyvo.petguardian.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Exemplo no AccountRequest.java
public record AccountRequest(
        @Schema(example = "usuario@petguardian.com")
        @NotBlank @Email String email,

        @Schema(example = "senha123")
        @NotBlank String password,

        @Schema(example = "TUTOR")
        @NotNull Role role,

        @Schema(example = "true")
        @NotNull Boolean active
) {}