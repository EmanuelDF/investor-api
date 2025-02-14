package com.example.resource;

import com.example.model.Investor;
import com.example.service.InvestorService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/investors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvestorResource {

    @Inject
    InvestorService investorService;

    @GET
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @GET
    @Path("/{id}")
    public Investor getInvestor(@PathParam("id") Long id) {
        return investorService.getInvestor(id);
    }

    @POST
    @Transactional
    public Response createInvestor(Investor investor) {
        investorService.createInvestor(investor);
        return Response.status(Response.Status.CREATED).entity(investor).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateInvestor(@PathParam("id") Long id, Investor investor) {
        investorService.updateInvestor(id, investor);
        return Response.ok(investor).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteInvestor(@PathParam("id") Long id) {
        investorService.deleteInvestor(id);
        return Response.noContent().build();
    }
}