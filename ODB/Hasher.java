/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wawafoods;

/**
 *
 * @author Shay
 */
import java.math.BigInteger;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
public class Hasher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            
               
            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("$objectdb/db/users.odb");
            EntityManager em = emf.createEntityManager();
            
            // Store 1000 Point objects in the database:
            em.getTransaction().begin();
		Map<String, String> properties = new HashMap<String, String>();
		String username = "Bob";
		String password = "guest";
		properties.put("username", username);
		properties.put("password", password);
		System.out.println(properties.get("username"));
                System.out.println(properties.get("password"));
		for (String key : properties.keySet()) {
			System.out.println(key);
			System.out.println(properties.get(key));
                        System.out.println(properties.get(properties.hashCode()));
			System.out.println();
			
		}
		
                
                for (int i = 0; i < properties.size(); i++) {
                    byte[] salt = new byte[16];
                    try {
                        Random r = new Random();
                        r.nextBytes(salt);

                        KeySpec spec = new PBEKeySpec(properties.get("password").toCharArray(), salt, 65536, 128);
                        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                        byte[] hash = f.generateSecret(spec).getEncoded();
                        System.out.println("salt: " + new BigInteger(1, salt).toString(16));
                        System.out.println("hash: " + new BigInteger(1, hash).toString(16));
                        String hPassword = new BigInteger(1, hash).toString(16);
                        User u = new User(properties.get("username"), hPassword);
                        em.persist(u);
                    }
                    catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    
                }
                em.getTransaction().commit();
                em.close();
                emf.close();
                
                
		
	}

}