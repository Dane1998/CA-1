/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Cars;
import facades.CarsFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author lassebirk
 */
@Path("cars")
public class CarsResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final CarsFacade carFacade = CarsFacade.getCarsFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    
    
   @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Car\"}";
    }

    
    @Path("add")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String persistCars() {
        carFacade.persistCars();
        return "Du har added biler";
    }
    
    
    
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cars> getAllCars() {
        List<Cars> allCars = carFacade.getAllCars();
        return allCars;
    }
    
    
    
}
