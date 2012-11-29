package hoagie;
 
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class SandwichMap implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
    private int ingred_id;          //ingredient id from HoagieIngredients class
    private int hoagie_id;          //hoagie id from Hoagie class   
    private int amount;             //how much/many (slices for example)
    private Date signingDate;
 
    // Constructors:
    public SandwichMap() {
    }
 
    public SandwichMap(int ingred_id, int hoagie_id) {
        this.ingred_id = ingred_id;
        this.hoagie_id = hoagie_id;
        this.signingDate = new Date(System.currentTimeMillis());  
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public int getIngred_id() {
        return ingred_id;
    }

    public int getHoagie_id() {
        return hoagie_id;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public int getAmount() {
        return amount;
    }
 
    // String Representation:
    @Override
    public String toString() {
        return "Hoagie_id: " + hoagie_id + "Ingredient_id: " + ingred_id + "Amount:  " + amount + "Signing Date: " + signingDate;
    }
}
