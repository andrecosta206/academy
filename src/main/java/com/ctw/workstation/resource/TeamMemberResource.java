package com.ctw.workstation.resource;

import com.ctw.workstation.dto.TeamMemberDTO;
import com.ctw.workstation.entity.TeamMember;
import com.ctw.workstation.service.TeamMemberService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/team-members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamMemberResource {
    @Inject
    TeamMemberService teamMemberService;
    @GET
    public List<TeamMember> getAll(){
        return teamMemberService.getTeamMembers();
    }

    @POST
    public Response create(TeamMemberDTO teamMemberDTO){
        TeamMember teamMember = teamMemberService.createTeamMember(teamMemberDTO);
        if(teamMember == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.CREATED).entity(teamMember).build();
    }
}
