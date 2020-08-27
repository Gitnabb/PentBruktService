package org.ntnu.PentBruktService.Service;

import org.ntnu.PentBruktService.misc.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {

    public List<Item> getAllItems(){

        Item i1 = new Item(1,
                "Iphone",
                null,
                "Hjalmar");

        Item i2 = new Item(2,
                "Sovepose",
                null,
                "Trude");

        List<Item> itemList = new ArrayList<>();
        itemList.add(i1);
        itemList.add(i2);

        // Create JSON objects
        // Jsonb jsonb = JsonBuilder.create();
        // String result = json.toJson(itemList);

        return itemList;
    }



}
