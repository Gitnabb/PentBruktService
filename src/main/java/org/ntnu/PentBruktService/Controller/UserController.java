package org.ntnu.PentBruktService.Controller;

import org.ntnu.PentBruktService.Domain.User;
import org.ntnu.PentBruktService.Service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    private UserService userService = new UserService();


    @GET
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @POST
    public User addUser(User user){
        return userService.addUser(user);
    }

    @GET
    @Path("/{userName}")
    public User getUser(@PathParam("userName") String userName){
        return userService.getUser(userName);
    }

    @PUT
    @Path("/{userName}")
    public User updateUser(@PathParam("userName") String userName, User user){
        user.setUserName(userName);
        return userService.updateUser(user);
    }

    @DELETE
    @Path("/{userName}")
    public User deleteUser(@PathParam("userName") String userName){
        return userService.removeUser(userName);
    }


}
