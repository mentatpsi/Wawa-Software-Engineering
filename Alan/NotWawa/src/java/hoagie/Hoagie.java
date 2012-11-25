package hoagie;
 
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Hoagie implements Serializable {
    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
    private String name;
    private Date signingDate;
 
    // Constructors:
    public Hoagie() {
    }
 
    public Hoagie(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }
 
    // String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}
