package hoagie;
 
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;


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
    
    // Store a new HoagieMap
    public void persistHoagieMap (HoagieMap hoagiemap){
        em.persist(hoagiemap);
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
    
    public List<HoagieMap> getMapForHoagie(int hoag) {
        TypedQuery<HoagieMap> query = em.createQuery(
            "SELECT hm FROM HoagieMap hm where hm.hoagie_id = :hoag", HoagieMap.class);
        
        return query.getResultList(); 
    }
    
    public HoagieIngredients getTotal(int hoag) {
        List<HoagieIngredients> hingrs = this.getIngrsForHoagie(hoag);
        HoagieIngredients hoagieIngr = new HoagieIngredients();
        int calories = 0;
        int totalFat = 0;
        int saturatedFat = 0;
        int carbs = 0;
        int fiber = 0;
        int protein = 0;
        
        
        for (HoagieIngredients hIngr : hingrs) {
            calories+= hIngr.getCalories();
            totalFat+= hIngr.getTotalFat();
            saturatedFat+= hIngr.getSatFat();
            carbs+= hIngr.getCarbs();
            fiber+= hIngr.getFiber();
            protein+= hIngr.getProtein();
            
            
        }
        
        hoagieIngr.setCalories(calories);
        hoagieIngr.setCarbs(carbs);
        hoagieIngr.setFiber(fiber);
        hoagieIngr.setSatFat(saturatedFat);
        hoagieIngr.setProtein(protein);
        
        hoagieIngr.setId(Long.getLong(String.valueOf(hoag))); //TODO: Might be goot to give a value
        
        return hoagieIngr;
    }

    
    public List<HoagieIngredients> getIngrsForHoagie(int hoag) {
        List<HoagieMap> hMaps = this.getMapForHoagie(hoag);
        ArrayList<HoagieIngredients> hIngrs = new ArrayList();
        
        for (HoagieMap hMap : hMaps) {
            int curIngr = hMap.getIngredient_id();
            TypedQuery<HoagieIngredients> ingrQuery = em.createQuery(
            "SELECT hi FROM HoagieIngredients hi where hi.id = :curIngr", HoagieIngredients.class);
            
            hIngrs.add(ingrQuery.getSingleResult());
        }
        return hIngrs;
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