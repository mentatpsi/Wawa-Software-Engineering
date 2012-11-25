package hoagie;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



public class HoagieDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

 
    // Stores a new guest: 
    public void persist(Hoagie hoagie) {
        //em.getTransaction().begin();
        em.persist(hoagie);
        //em.getTransaction().commit();
    }
 
    // Retrieves all the guests:
    public List<Hoagie> getAllHoagies() {
        TypedQuery<Hoagie> query = em.createQuery(
            "SELECT h FROM Hoagie h ORDER BY h.id", Hoagie.class);
        return query.getResultList();
    }
}