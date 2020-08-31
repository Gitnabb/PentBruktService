package org.ntnu.PentBruktService.Controller;
import org.ntnu.PentBruktService.Service.ItemService;
import org.ntnu.PentBruktService.Domain.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/items") // maps class to url postfix "items"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {

    ItemService itemService = new ItemService();

    @GET
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

    @POST
    public Item addItem(Item item){
        return itemService.addItem(item);

    }

    @GET
    @Path("/{itemId}")
    public Item getItem(@PathParam("itemId") Long itemId){

        return itemService.getItem(itemId);

    }

    @PUT
    @Path("/{itemId}")
    public Item updateItem(@PathParam("itemId") Long itemId, Item item){
        item.setItemId(itemId);
        return itemService.updateItem(item);
    }

    @DELETE
    @Path("/{itemId}")
    public void deleteItem(@PathParam("itemId") Long itemId) {
        itemService.removeItem(itemId);
    }
}
