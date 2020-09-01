package org.ntnu.PentBruktService.Controller;

import org.ntnu.PentBruktService.Domain.User;
import org.ntnu.PentBruktService.Service.UserService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService userService;

    @GET
    @Path("users")
    public Response getUsers(){
        return Response.ok(this.userService.getAllUsers()).build();
    }

    // REgister

    @POST
    @Path("register-user")
    public Response registerUser(User user){
        if(this.userService.registerUser(user)){
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("login")
        public Response login(User user){
            System.out.println("Email " + user.getEmail() + ", Password: " + user.getPassword());
            if(this.userService.login(user.getEmail(), user.getPassword())){
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

        }

}
