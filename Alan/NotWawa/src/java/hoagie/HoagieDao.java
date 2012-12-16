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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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
    
    public Hoagie getHoagiebyId(int hid){
        // Return a hoagie object by its known id
        // get SingleResult() assumes no duplicates in db
        
        TypedQuery<Hoagie> query = em.createQuery(
                "SELECT h FROM Hoagie h WHERE h.id = :hid", Hoagie.class);
        return query.setParameter("hid", hid).getSingleResult();
                
    }
    
    public Hoagie getHoagieByName(String hoagieName){
        // Return a hoagie object by hoagieName
        // getSingleResult() assumes there are no duplicates in the db
        
        TypedQuery<Hoagie> query = em.createQuery(
                "SELECT h FROM Hoagie h WHERE h.name = :hoagieName", Hoagie.class);      
        return query.setParameter("hoagieName", hoagieName).getSingleResult();
    }
    
    public List<HoagieMap> getMapForHoagie(int hoag) {
        // get all hoagie map ingredients that match a certain hoagie id
        
        TypedQuery<HoagieMap> query = em.createQuery(
            "SELECT hm FROM HoagieMap hm where hm.hoagie_id = :hoag", HoagieMap.class);
        return query.setParameter("hoag", hoag).getResultList(); 
    }
    
    public HoagieIngredients getTotal(int hoag) {
        List<HoagieIngredients> hingrs = this.getIngrsForHoagie(hoag); //get ingredients for this hoagie
        HoagieIngredients hoagieIngr = new HoagieIngredients();  //create new ingredients object (for totals)
        List<HoagieMap> hMaps = this.getMapForHoagie(hoag); //get the hoagie map
        
        int calories = 0;
        int totalFat = 0;
        int saturatedFat = 0;
        int carbs = 0;
        int fiber = 0;
        int protein = 0;
        int sugars = 0;
        int caloriesFat = 0;
        int monoFat = 0;
        int polyFat = 0;
        int transFat = 0;
        int cholesterol = 0;
        int sodium = 0;
        int potassium = 0;
        
        long idx;
        int quantity;
        
        
        // make a map of ingredient_id:quantity
        Map<Integer, Integer> mp=new HashMap<Integer, Integer>();       
        for (HoagieMap hMap : hMaps){
            mp.put(hMap.getIngredient_id(), hMap.getQuantity());  
        }
        
        // sum nutritional information across all ingredients
        for (Iterator<HoagieIngredients> it = hingrs.iterator(); it.hasNext();) {
            HoagieIngredients hIngr = it.next();
            
            //get the quantity of this particular ingredient (4 slices of cheese, etc)
            idx = hIngr.getId();
            quantity = mp.get((int)idx);
            
            // start the summing and multiplying by quantity
            calories+= hIngr.getCalories() * quantity;
            totalFat+= hIngr.getTotalFat() * quantity;
            saturatedFat+= hIngr.getSatFat() * quantity;
            carbs+= hIngr.getCarbs() * quantity;
            fiber+= hIngr.getFiber() * quantity;
            protein+= hIngr.getProtein() * quantity;
            sugars+= hIngr.getSugars() * quantity;
            caloriesFat+= hIngr.getCalories() * quantity;
            monoFat+= hIngr.getMonoFat() * quantity;
            polyFat+= hIngr.getPolyFat() * quantity;
            transFat+= hIngr.getTransFat() * quantity;
            cholesterol+= hIngr.getCholesterol() * quantity;
            sodium+= hIngr.getSodium() * quantity;
            potassium+= hIngr.getPotassium() * quantity;
        }
   
        //set the sums in the new hoagie ingredient object
        hoagieIngr.setCalories(calories);
        hoagieIngr.setCarbs(carbs);
        hoagieIngr.setFiber(fiber);
        hoagieIngr.setSatFat(saturatedFat);
        hoagieIngr.setProtein(protein);
        hoagieIngr.setSugars(sugars);
        hoagieIngr.setCaloriesFat(caloriesFat);
        hoagieIngr.setMonoFat(monoFat);
        hoagieIngr.setPolyFat(polyFat);
        hoagieIngr.setTransFat(transFat);
        hoagieIngr.setCholesterol(cholesterol);
        hoagieIngr.setSodium(sodium);
        hoagieIngr.setPotassium(potassium);      
        hoagieIngr.setId(Long.getLong(String.valueOf(hoag))); //TODO: Might be good to give a value
        
        return hoagieIngr;
    }


    
    public List<HoagieIngredients> getIngrsForHoagie(int hoag) {
        List<HoagieMap> hMaps = this.getMapForHoagie(hoag);
        ArrayList<HoagieIngredients> hIngrs = new ArrayList();
        
        for (HoagieMap hMap : hMaps) {
            int curIngr = hMap.getIngredient_id();
            TypedQuery<HoagieIngredients> ingrQuery = em.createQuery(
            "SELECT hi FROM HoagieIngredients hi where hi.id = :curIngr", HoagieIngredients.class);
            
            hIngrs.add(ingrQuery.setParameter("curIngr", curIngr).getSingleResult());
        }
        return hIngrs;
    }
    
    // Retrieves all the ingredients:
    public List<HoagieIngredients> getAllIngredients() {
        TypedQuery<HoagieIngredients> query = em.createQuery(
            "SELECT g FROM HoagieIngredients g", HoagieIngredients.class);
        return query.getResultList();
    }
    
    public List<HoagieMap> getAllHoagieMaps() {
        TypedQuery<HoagieMap> query = em.createQuery(
            "SELECT hm FROM HoagieMap hm", HoagieMap.class);
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
    
    public HoagieIngredients getIngrByName(String ingrName){
        // Return a hoagieIngredient object by hoagieIngredientName
        // getSingleResult() assumes there are no duplicates in the db
        
        TypedQuery<HoagieIngredients> query = em.createQuery(
                "SELECT hi FROM HoagieIngredients hi WHERE hi.name = :ingrName", HoagieIngredients.class);      
        return query.setParameter("ingrName", ingrName).getSingleResult();
    }
    
    // verifies user exists in db, returns boolean 
    public boolean verifyUserExists(String u) {
        TypedQuery<Password> query = em.createQuery(
            "SELECT p FROM Password p WHERE p.userName = :u", Password.class);
        List<Password> c = query.setParameter("u", u).getResultList();
        return (!c.isEmpty());  //boolean
    }
}