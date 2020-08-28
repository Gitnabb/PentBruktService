package org.ntnu.PentBruktService.Database;

import org.ntnu.PentBruktService.Domain.Item;
import org.ntnu.PentBruktService.Domain.User;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<Long, Item> items = new HashMap<>();
    private static Map<String, User> users = new HashMap<>();

    public static Map<Long, Item> getItems(){
        return items;
    }

    public static Map<String, User> getUsers(){
        return users;
    }

}
