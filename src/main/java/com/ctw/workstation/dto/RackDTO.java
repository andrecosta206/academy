package com.ctw.workstation.dto;

import java.util.UUID;

public record RackDTO(
        UUID id,
        String serialNumber,
        UUID teamId,
        String defaultLocation,
        boolean isReserved
) {
}
