package com.ctw.workstation.service;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.mapper.RackMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService {
    @Inject
    TeamService teamService;
    RackMapper rackMapper;


    public RackService() {
        rackMapper = new RackMapper();
    }

    public List<RackDTO> getRacks(){
        return Rack.listAll().stream().
                map(rack -> rackMapper.toRackDTO((Rack) rack)).toList();
    }

    @Transactional
    public RackDTO createRack(RackDTO rackDTO){
        Team team = teamService.getTeamById(rackDTO.teamId());
        if(team == null) {
            throw new RuntimeException("Team not found");
        }
        Rack rack = rackMapper.toRack(rackDTO);
        rack.persist();
        return rackMapper.toRackDTO(rack);
    }

    @Transactional
    public boolean deleteRack(UUID id) {
        return Rack.deleteById(id);
    }

    @Transactional
    public RackDTO patchReservation(UUID id) {
        Rack rack = Rack.findById(id);
        if(rack == null) {
            throw new RuntimeException("Rack not found");
        }
        rack.isReserved = !rack.isReserved;
        rack.persist();
        Log.info("Patching reservation for " + rack.toString());
        return rackMapper.toRackDTO(rack);
    }

    public RackDTO getRackById(UUID id) {
        Rack rack = Rack.findById(id);
        if(rack == null) {
            throw new RuntimeException("Rack not found");
        }
        return rackMapper.toRackDTO(rack);
    }
}
