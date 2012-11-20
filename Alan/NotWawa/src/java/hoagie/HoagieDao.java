/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 

@Stateless
public class HoagieDao {

    // Injected database connection:
    @PersistenceContext private EntityManager em;
    
    // Stores a new guest: 
    public void persist(Hoagie hoagie) {
        em.persist(hoagie);
    }
    
    // Retrieves all the hoagie types:
    public List<Hoagie> getHoagieTypes() {
        TypedQuery<Hoagie> query = em.createQuery(
            "SELECT h FROM Hoagie g ORDER BY g.id", Hoagie.class);
        return query.getResultList();
    }

}
