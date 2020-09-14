package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Test Web Service
 *
 * @author lam
 */
@Path("test")
public class TestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestResource
     */
    public TestResource() {
    }

     @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        /*
        System.out.println("DEPLOYED       -->"+System.getenv("DEPLOYED"));
        System.out.println("USER           -->"+System.getenv("USER"));
        System.out.println("PW             -->"+System.getenv("PW"));
        System.out.println("CONNECTION_STR -->"+System.getenv("CONNECTION_STR"));
        */
        return "{\"msg\":\"Hello World\"}";
    }
}
