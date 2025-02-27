package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;

public class TeamMapper {

    // mapp team to dto and dto to team
    public TeamDTO toTeamDTO(Team team) {
        return new TeamDTO(
                team.id,
                team.name,
                team.product,
                team.defaultLocation);
    }

    public Team toTeam(TeamDTO teamDTO) {
        return new Team(
                teamDTO.id(),
                teamDTO.name(),
                teamDTO.product(),
                teamDTO.default_location()
        );
    }
}
