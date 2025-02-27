package com.ctw.workstation.resource;

import com.ctw.workstation.dto.RackDTO;
import com.ctw.workstation.entity.Rack;
import com.ctw.workstation.service.RackService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/racks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackResource {
    @Inject
    RackService rackService;

    @GET
    public List<RackDTO> getRacks() {
        return rackService.getRacks();
    }

    @GET
    @Path("/{id}")
    public Response getRackById(@PathParam("id") UUID id) {
       RackDTO rack = rackService.getRackById(id);
       if(rack != null){
           return Response.ok(rack).build();
       }
       return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    public Response addRack(RackDTO rackDTO) {
        RackDTO rack= rackService.createRack(rackDTO);

        if(rack != null) {
            return Response.status(Response.Status.CREATED).entity(rack).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") UUID id) {
        boolean deleted =rackService.deleteRack(id);
        if(deleted) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PATCH
    @Path("/{id}")
    public Response patchRackReservation(@PathParam("id") UUID id){
        RackDTO rack = rackService.patchReservation(id);
        if(rack != null) {
            return Response.status(Response.Status.OK).entity(rack).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
