/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie;
 
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Hoagie implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;
    private Date signingDate;
   
 
    // Constructors:
    public Hoagie() {
    }
 
    public Hoagie(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }
    //set ALL attributes

    
    // String Representation:
    @Override
    public String toString() {
        return  "<br/>";
    }
}