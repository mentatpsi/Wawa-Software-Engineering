/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wawafoods;

import javax.persistence.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class HashTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/users.odb");
            EntityManager em = emf.createEntityManager();
        
        Query q1 = em.createQuery("SELECT COUNT(u) FROM User u");
        System.out.println("Total Users: " + q1.getSingleResult());
            
        TypedQuery<User> query =
                em.createQuery("SELECT u FROM User u", User.class);
                List<User> results = query.getResultList();
                for (User u : results) {
                    System.out.println(u);
                }
                
        em.close();
        emf.close();
    }
}
