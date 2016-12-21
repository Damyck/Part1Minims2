package edu.upc.dsa;

import edu.upc.dsa.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Marc on 21/12/2016.
 */
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserApi {
    Singleton userWorker;


    public UserApi(){
        userWorker = Singleton.getInstance();
        userWorker.insertUser("pepe", "ahdnc");
        userWorker.insertUser("Juan", "Alolalo");
    }

    @POST
    @Path("/new")
    public Response newUser(User user){
        String name = user.getName();
        String password = user.getPassword();
        userWorker.insertUser(name, password);
        return Response.status(201).entity("User added in position "+userWorker.getCont()).build();
    }

    @POST
    @Path("/post")
    public Response createUserInJSON(User user){
        String result = "User saved : " + userWorker.getUsers();
        return Response.status(201).entity(result).build();
    }

    @POST
    @Path("/new/etakemon")
    public Response addEtak(User user){
        String name = user.getName();
        List<Etakemon> etak = user.getEtak();
        Etakemon etakemon = etak.get(0);
        userWorker.addEtakemon(name, etakemon);
        return Response.status(201).entity("New Etakemon "+userWorker.getCont()).build();
    }

    @POST
    @Path("/post")
    public Response addEtakInJSON(User user){
        String name = user.getName();
        List<Etakemon> etak = user.getEtak();
        Etakemon etakemon = etak.get(0);
        String result = "Etakemon for" +name+ " added: " + etakemon;
        return Response.status(201).entity(result).build();
    }

    @GET
    @Path("/get/{etakName}")

    public Etakemon getEtakemonInJSON(@PathParam("etakName") String etakName) {
        return userWorker.showEtakemon(etakName);
    }

    @GET
    @Path("/get/{userName}")

    public User getUserInJSON(@PathParam("userName") String userName) {
        return userWorker.showUser(userName);
    }

    @GET
    @Path("/get/etakemon/{userName}")
    public List<Etakemon> getUserEtakemonInJSON(@PathParam("userName") String userName) {

        return userWorker.showuserEtakemon(userName);
    }

    @GET
    @Path("/hello")
    public String hello() {
        return "Hello MArc";
    }
}
