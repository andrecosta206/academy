package com.ctw.workstation.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TeamMemberDTO(
        UUID id,
        String name,
        String ctw_id,
        UUID team_id
) {


}
