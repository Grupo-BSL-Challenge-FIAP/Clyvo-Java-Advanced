package br.com.clyvo.petguardian.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ResponsibleRequest(
        @NotBlank String fullName,
        @NotBlank String cpf,
        @NotNull LocalDate dateOfBirth,
        String phoneNumber,
        String address,
        @NotNull Long accountId
) {}