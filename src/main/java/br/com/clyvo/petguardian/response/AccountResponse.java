package br.com.clyvo.petguardian.response;

import br.com.clyvo.petguardian.entity.Role;
import java.time.LocalDateTime;

public record AccountResponse(
        Long id,
        String email,
        Role role,
        Boolean active,
        LocalDateTime createdAt
) {}