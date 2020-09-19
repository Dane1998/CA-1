package facades;

import utils.EMF_Creator;
import entities.Jokes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class JokesFacadeTest {

    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private final Jokes j1 = new Jokes("Hvad kalder man to lamaer, der er kriminelle?", "Bal’lamaer");
    private final Jokes j2 = new Jokes("Hvad er det værste ved at slå op med en japansk pige?", "Du er nødt til at smide bomben to gange, før hun forstår beskeden");
            
    public JokesFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = JokeFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Jokes.deleteAllJokes").executeUpdate();
            em.persist(j1);
            em.persist(j2);                    
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testGetAllMembers() {
        assertEquals(2, facade.getJokesCount(), "Expects tree rows in the database");
    }

}
