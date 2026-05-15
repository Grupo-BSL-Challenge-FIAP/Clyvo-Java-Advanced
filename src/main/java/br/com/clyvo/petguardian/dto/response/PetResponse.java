package br.com.clyvo.petguardian.dto.response;

import br.com.clyvo.petguardian.enums.CurrentStatus;
import java.time.LocalDate;

public record PetResponse(
        Long id,
        String name,
        String species,
        String breed,
        LocalDate birthDate,
        Double weight,
        CurrentStatus currentStatus,
        String responsibleName,
        String veterinarianName
) {}