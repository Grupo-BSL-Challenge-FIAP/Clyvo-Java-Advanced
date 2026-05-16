package br.com.clyvo.petguardian.dto.request;

import br.com.clyvo.petguardian.enums.AlertStatus; // Importe o Enum de Status
import br.com.clyvo.petguardian.enums.AlertType;
import br.com.clyvo.petguardian.enums.RiskLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlertRequest(
        @NotNull(message = "O tipo do alerta é obrigatório")
        AlertType type,

        @NotBlank(message = "A mensagem é obrigatória")
        String message,

        @NotNull(message = "O nível de risco é obrigatório")
        RiskLevel riskLevel,

        @NotNull(message = "O status é obrigatório")
        AlertStatus status,

        @NotNull(message = "O ID do pet é obrigatório")
        Long petId
) {}