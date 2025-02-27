package com.ctw.workstation.service;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.mapper.TeamMapper;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TeamService {
    @Inject
    TeamRepository teamRepository;
    TeamMapper teamMapper;

    //private static final Logger log = Logger.getLogger(TeamService.class);
    @Inject
    Logger logger;

    public TeamService() {
        this.teamMapper = new TeamMapper();
    }

    public List<TeamDTO> getTeams() {
        return teamRepository.listAll().stream()
                .map(team -> teamMapper.toTeamDTO(team)).toList();
    }

    public Team getTeamById(UUID id) {
        return Team.findById(id);
//        return teamRepository.findById(id);
    }

    @Transactional
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = teamMapper.toTeam(teamDTO);
        logger.info(team.toString() + " details");
        team.persist();
        return teamMapper.toTeamDTO(team);
//        logger.info(team.toString() + " created");
    }
}
