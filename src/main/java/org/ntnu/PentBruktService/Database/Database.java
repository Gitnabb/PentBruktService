package org.ntnu.PentBruktService.Database;

import org.ntnu.PentBruktService.misc.Item;
import org.ntnu.PentBruktService.misc.Profile;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Map<Long, Item> items = new HashMap<>();
    private static Map<Long, Profile> profiles = new HashMap<>();

    public static Map<Long, Item> getItems(){
        return items;
    }

    public static Map<Long, Profile> getProfiles(){
        return profiles;
    }

}
