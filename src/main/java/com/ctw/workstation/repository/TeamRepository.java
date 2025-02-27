package com.ctw.workstation.repository;

import com.ctw.workstation.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<Team> {

    public Team findByName(String name) {
        return find("name", name).firstResult();
    }

    public Team findById(UUID id){
        return find("id", id).firstResult();
    }

}
