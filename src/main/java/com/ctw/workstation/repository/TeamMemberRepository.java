package com.ctw.workstation.repository;

import com.ctw.workstation.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepository<TeamMember> {
    public List<TeamMember> findByTeamId(UUID teamId) {
        return find("teamId = ?1", teamId).list();
    }

    public TeamMember findById(UUID id){
        return find("id",id).firstResult();
    }
}
