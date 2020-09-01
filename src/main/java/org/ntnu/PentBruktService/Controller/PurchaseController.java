package org.ntnu.PentBruktService.Controller;

import org.ntnu.PentBruktService.Domain.Purchase;
import org.ntnu.PentBruktService.Service.ListingService;
import org.ntnu.PentBruktService.Service.PurchaseService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("purchase")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PurchaseController {

    @Inject
    public PurchaseService purchaseService;

    @GET
    @Path("purchases")
    public Response getAllPurchases(){
        return Response.ok(this.purchaseService.getAllPurchases()).build();
    }

    @POST
    @Path("register-purchase")
    public Response registerPurchase(Purchase purchase){
        if(this.purchaseService.registerPurchase(purchase)){
            return Response.ok().build();
        }  else
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
