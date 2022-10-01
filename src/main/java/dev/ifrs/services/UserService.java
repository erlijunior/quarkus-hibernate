package dev.ifrs.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ifrs.entity.User;

@Path("/user")
@Transactional
public class UserService {
    
    @GET
    @Path("/add/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        user.persist();
        return user;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser() {
        return User.listAll();
    }
}
