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
public class Ingredients implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;

    // Constructors:
    public Ingredients() {
    }
 
    public Ingredients(String name) {
        this.name = name;
    }
 
    // String Representation:
    @Override
    public String toString() {
        return name + "<br/>";
    }
}