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
public class Sandwich implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private int hoagie_id;
    private int ingred_id;
    private int count;
    private Date signingDate;
 
    // Constructors:
    public Sandwich() {
    }
 
    public Sandwich(int hoagie_id, int ingred_id, int count) {
        this.hoagie_id = hoagie_id;     //id of the hoagie 
        this.ingred_id = ingred_id;     //id of the ingredient
        this.count = count;             //how many slices
        this.signingDate = new Date(System.currentTimeMillis());
    }
 
    // String Representation:
    @Override
    public String toString() {
        return "<br/>";
    }
}