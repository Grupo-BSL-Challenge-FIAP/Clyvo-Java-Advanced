package br.com.clyvo.petguardian.dto.response;

import br.com.clyvo.petguardian.enums.AppointmentStatus;
import java.time.LocalDateTime;

public record AppointmentResponse(
        Long id,
        LocalDateTime appointmentDate,
        String reason,
        String diagnosis,
        String recommendation,
        AppointmentStatus status,
        LocalDateTime createdAt,
        String petName,
        String veterinarianName
) {}