package org.ntnu.PentBruktService.Service;

import org.ntnu.PentBruktService.Database.Database;
import org.ntnu.PentBruktService.Domain.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemService {

    private static Map<Long, Item> items = Database.getItems();

    public ItemService(){

        items.put(1L, new Item(1, "iPhone X", "Hjalmar"));
        items.put(2L, new Item(2, "Støvsuger", "Trude"));
        items.put(3L, new Item(3, "Kuksuger", "Trude2"));

    }

    public List<Item> getAllItems(){

        return new ArrayList<>(items.values());
        // Create JSON objects
        // Jsonb jsonb = JsonBuilder.create();
        // String result = json.toJson(itemList);

    }

    public Item getItem(long id){
        return items.get(id);
    }

    public Item addItem(Item item){
        item.setItemId(items.size() + 1);
        items.put(item.getItemId(), item);
        return item;
    }


    public Item removeItem(long id){
        return items.remove(id);
    }

    /*
     public Item updateItem(Item item){
        if ( item.getIt <= 0){
            return null;

        }
        items.put(item.getId(), message);
        return item;

    }
     */





}
