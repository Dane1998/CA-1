package facades;

import entities.Jokes;
import entities.Cars;
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
public class CarsFacade {

    private static CarsFacade instance;
    private static EntityManagerFactory emf;
    private final Cars car1 = new Cars("Hans Jensen", 1992, "Volvo", "V70", 5000);
    private final Cars car2 = new Cars("Anders Mikkelsen", 1993, "Ford", "E350", 4500);
    private final Cars car3 = new Cars("Katrine Blixen", 1999, "Chevy", "Venture", 4500);

    //Private Constructor to ensure Singleton
    private CarsFacade() {
    }

    public static CarsFacade getCarsFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarsFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Cars> getAllCars() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Cars.getAllCars");
            List<Cars> cars = query.getResultList();
            return cars;
        } finally {
            em.close();
        }
    }

    public void persistCars() {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.createNamedQuery("Cars.deleteAllCars").executeUpdate();
            em.persist(car1);
            em.persist(car2);
            em.persist(car3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public long getCarCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long carCount = (long) em.createQuery("SELECT COUNT(c) FROM Cars c").getSingleResult();
            return carCount;
        } finally {
            em.close();
        }
    }

}