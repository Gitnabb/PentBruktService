package org.ntnu.PentBruktService.Controller;
import org.ntnu.PentBruktService.Service.ItemService;
import org.ntnu.PentBruktService.Domain.Item;
import sun.plugin2.message.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/allitems") // maps class to url postfix "items"
public class ItemController {

    ItemService itemService = new ItemService();

    @GET
    @Produces(MediaType.APPLICATION_JSON) // Could be JSON/JSON-OBJ
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Item addItem(Item item){
        return itemService.addItem(item);

    }

    @GET
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item getItem(@PathParam("itemId") Long itemId){

        return itemService.getItem(itemId);

    }

    @PUT
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)

    public Message updateItem(Item item){
        return itemService.updateItem(item);
    }



}
