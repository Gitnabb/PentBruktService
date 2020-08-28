package org.ntnu.PentBruktService.Service;

import org.ntnu.PentBruktService.Database.Database;
import org.ntnu.PentBruktService.Domain.Item;
import org.ntnu.PentBruktService.Domain.User;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {

    private static Map<String, User> users = Database.getUsers();

    public UserService() {

        users.put("Kjetil", new User(1L, "ExtremeLudvig", "Kjetil", "Hammerseth"));

    }

    public List<User> getAllUsers(){

        return new ArrayList<User>(users.values());

    }

    public User getUser(String userName){
        return users.get(userName);
    }

    public User addUser(User user){
        user.setId(users.size() + 1);
        users.put(user.getUserName(), user);
        return user;
    }

    public User updateUser(User user){

        if(user.getUserName().isEmpty()){
            return null;
        }
        users.put(user.getUserName(), user);
        return user;

    }

    public User removeUser(String userName){
        return users.remove(userName);
    }

}
