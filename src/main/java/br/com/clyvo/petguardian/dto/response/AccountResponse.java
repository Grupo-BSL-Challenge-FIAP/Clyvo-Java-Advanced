package br.com.clyvo.petguardian.dto.response;

import br.com.clyvo.petguardian.enums.Role;
import java.time.LocalDateTime;

public record AccountResponse(
        Long id,
        String email,
        Role role,
        Boolean active,
        LocalDateTime createdAt
) {}