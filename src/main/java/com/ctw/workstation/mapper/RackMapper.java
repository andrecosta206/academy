package com.ctw.workstation.mapper;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.entity.Team;

public class RackMapper {
    public RackDTO toRackDTO(Rack rack) {
        return new RackDTO(
                rack.id,
                rack.serialNumber,
                rack.team.id,
                rack.defaultLocation,
                rack.isReserved
        );
    }

    public Rack toRack(RackDTO rackDTO) {
        return new Rack(
                rackDTO.id(),
                rackDTO.serialNumber(),
                rackDTO.defaultLocation(),
                Team.findById(rackDTO.teamId()),
                rackDTO.isReserved()
        );
    }
}
