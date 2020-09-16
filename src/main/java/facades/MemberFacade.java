package facades;

import entities.Members;
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
public class MemberFacade {
    
    private static MemberFacade instance;
    private static EntityManagerFactory emf;
    private final Members m1 = new Members("Pidaras", "Russia");
    private final Members m2 = new Members("Suka", "Dibil");
    private final Members m3 = new Members("Putin", "Love");
    //Private Constructor to ensure Singleton
    private MemberFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MemberFacade getFacadeExample(EntityManagerFactory _emf) {
       
       emf = EMF_Creator.createEntityManagerFactory();
  
    
        if (instance == null) {
            emf = _emf;
            instance = new MemberFacade();
        }
        return instance;
    }


    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Members> getAllMembers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Members.getAllMembers");
            List<Members> allMembers = query.getResultList();
            return allMembers;
        } finally {
            em.close();
        }

    }

    public void addMembers() {
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            em.createNamedQuery("Members.deleteAllMembers");
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public long getMemberCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long memberCount = (long)em.createQuery("SELECT COUNT(m) FROM Members m").getSingleResult();
            return memberCount;
        }finally{  
            em.close();
        }
    }

}
