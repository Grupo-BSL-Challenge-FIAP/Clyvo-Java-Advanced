package br.com.clyvo.petguardian.dto.response;

import br.com.clyvo.petguardian.enums.AlertStatus;
import br.com.clyvo.petguardian.enums.AlertType;
import br.com.clyvo.petguardian.enums.RiskLevel;
import java.time.LocalDateTime;

public record AlertResponse(
        Long id,
        AlertType type,
        String message,
        RiskLevel riskLevel,
        AlertStatus status,
        LocalDateTime createdAt,
        LocalDateTime resolvedAt,
        String petName
) {}