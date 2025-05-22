package org.example.labseq.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.labseq.service.LabseqService;



@Path("/labseq")
@Tag(name = "Labseq", description = "Labseq sequence operations")
public class LabseqController{

    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get labseq value", description = "Returns the value at position n in the labseq sequence")
    @APIResponse(responseCode = "200", description = "Success")
    @APIResponse(responseCode = "400", description = "Invalid input - n must be non-negative")
    public Response getLabseqValue(
            @Parameter(description = "Index of the sequence (non-negative integer)", required = true)
            @PathParam("n") int n) {

        if (n < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Index must be non-negative\"}")
                    .build();
        }

        try {
            long result = labseqService.calculateLabseq(n);
            return Response.ok("{\"result\": " + result + "}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Calculation error\"}")
                    .build();
        }
    }
}