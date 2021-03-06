package facades;

import DTO.JokeDTO;
import DTO.JokesDTO;
import entities.Jokes;
import entities.Members;
import static entities.ghy636765.Jokes_.id;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;
    private final Jokes j1 = new Jokes("Why does Waldo wear stripes?", "Because he does not want to be spotted.");
    private final Jokes j2 = new Jokes("To be frank,", "I would have to change my name.");
    private final Jokes j3 = new Jokes("A naked guy just dunked his balls in glitter", "That is pretty nuts.");

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getJokesFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<JokesDTO> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Jokes.getAllJokes");
            List<JokesDTO> allJokes = query.getResultList();
            return allJokes;
        } finally {
            em.close();
        }
    }
    
        
    public Jokes getJokeById(long id){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createNamedQuery("Jokes.getJokeById");
            query.setParameter("id",id);
            Jokes joke = (Jokes) query.getSingleResult();
            return joke;
        }finally{
            em.close();
        } 
    }
    
    public void addJokes() {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.createNamedQuery("Jokes.deleteAllJokes").executeUpdate();
            em.persist(j1);
            em.persist(j2);
            em.persist(j3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public long getJokesCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long jokeCount = (long) em.createQuery("SELECT COUNT(j) FROM Jokes j").getSingleResult();
            return jokeCount;
        } finally {
            em.close();
        }
    }

}
