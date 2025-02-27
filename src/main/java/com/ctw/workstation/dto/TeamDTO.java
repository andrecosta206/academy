package com.ctw.workstation.dto;

import java.util.UUID;

public record TeamDTO(
        UUID id,
        String name,
        String product,
        String default_location) {
}
