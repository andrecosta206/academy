package com.ctw.workstation.service;

import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.repository.TeamMemberRepository;
import com.ctw.workstation.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {
    @Inject
    TeamMemberRepository teamMemberRepository;
    @Inject
    TeamRepository teamRepository;

    public List<TeamMember> getTeamMembers() {
        return teamMemberRepository.listAll();
    }

    public TeamMember getTeamMemberById(UUID id) {
        return teamMemberRepository.findById(id);
    }

    public List<TeamMember> getTeamMembersByTeamId(UUID teamId) {
        return teamMemberRepository.findByTeamId(teamId);
    }

    @Transactional
    public TeamMember createTeamMember(TeamMemberDTO teamMemberDTO) {
        Team team = teamRepository.findById(teamMemberDTO.team_id());
        if(team == null) {
            throw new RuntimeException("Team not found");
        }
        try{
            TeamMember teamMember = new TeamMember();
            teamMember.setName(teamMemberDTO.name());
            teamMember.setCtwId(teamMemberDTO.ctw_id());
            teamMember.setTeamId(team.id);
            teamMemberRepository.persist(teamMember);
            return teamMember;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error creating team member", e);
        }
    }
}
