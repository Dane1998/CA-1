    package rest;


import DTO.JokesDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Jokes;
import facades.JokeFacade;
import utils.EMF_Creator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("jokes")
public class JokesResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    private static final JokeFacade FACADE = JokeFacade.getJokesFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Joke's on you\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<JokesDTO> getAllJokes() {
        List<JokesDTO> allJokes = FACADE.getAllJokes();
        return allJokes;    
    }
    
   @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Jokes getJokeById(@PathParam("id") int id){
        Jokes joke = FACADE.getJokeById(id);
        return joke;
    }
    
    @Path("add")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String addMembers() {
        FACADE.addJokes();
        return "Why so serious?";
    }
}
