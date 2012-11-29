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
    public void persistUserPass(Password p){
        em.persist(p);    
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
            "SELECT g FROM HoagieIngredients g", HoagieIngredients.class);
        return query.getResultList();
    }
    
    // Retrieves users password, returns StringBuilder
    public String getUserPass(String u) {
        /*if(verifyUserExists(u)){
            return null;
        }*/
        TypedQuery<Password> query = em.createQuery(
                "SELECT p FROM Password p where p.userName = :u", Password.class);
        Password elementList = query.setParameter("u", u).getSingleResult();
        return elementList.getPassword();
    }
    
    // verifies user exists in db, returns boolean 
    public boolean verifyUserExists(String u) {
        TypedQuery<Password> query = em.createQuery(
            "SELECT p FROM Password p WHERE p.userName = :u", Password.class);
        List<Password> c = query.setParameter("u", u).getResultList();
        return (!c.isEmpty());  //boolean
    }
}