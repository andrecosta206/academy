package com.ctw.workstation.resource;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {
    @Inject
    TeamService teamService;

    @GET
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

    @POST
    public Response addTeam(TeamDTO teamDTO) {
        TeamDTO team = teamService.createTeam(teamDTO);
        if(team != null) {
            return Response.status(Response.Status.CREATED).entity(team).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeam(@PathParam("id") UUID id) {
        Team team = teamService.getTeamById(id);
        return Response.status(Response.Status.OK).entity(team).build();
    }

}
