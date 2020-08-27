package org.ntnu.PentBruktService.Controller;
import org.ntnu.PentBruktService.Service.ItemService;
import org.ntnu.PentBruktService.misc.Item;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/allitems") // maps class to url postfix "items"
public class PentBruktController {

    ItemService itemService = new ItemService();

    @GET
    @Produces(MediaType.APPLICATION_XML) // Could be JSON/JSON-OBJ
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

}
