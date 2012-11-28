package hoagie;
 
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class HoagieDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

    public HoagieDao(){
    }
    
    // Stores a new hoagie: 
    public void persist(Hoagie hoagie) {
        em.persist(hoagie);
    }

    // Store a new ingredient
    public void persistIngredients(HoagieIngredients ingred){
        em.persist(ingred);
        
    }
    
    // Store a new user / password
    public void persistUserPass(Password pass){
        em.persist(pass);    
    }
    
    // Retrieves all the hoagies:
    public List<Hoagie> getAllHoagies() {
        TypedQuery<Hoagie> query = em.createQuery(
            "SELECT g FROM Hoagie g ORDER BY g.id", Hoagie.class);
        return query.getResultList();
    }
    
    // Retrieves all the ingredients:
    public List<HoagieIngredients> getAllIngredients() {
        TypedQuery<HoagieIngredients> query = em.createQuery(
            "SELECT i FROM HoagieIngredients i ORDER BY i.id", HoagieIngredients.class);
        return query.getResultList();
    }
    
    // Retrieves users password, returns StringBuilder
    public StringBuilder getUserPass(String u, StringBuilder p) {
        Query query = em.createQuery(
            "SELECT p.password FROM Password p WHERE p.userName = :u", String.class);
        StringBuilder c = (StringBuilder)query.getSingleResult();
        return c;
    }
    
    // verifies user exists in db, returns boolean 
    public boolean verifyUserExists(String u) {
        Query query = em.createQuery(
            "SELECT p.userName FROM Password p", Password.class);
        List<Password> elementList = query.getResultList();
        return elementList.isEmpty();  //boolean
    }
}