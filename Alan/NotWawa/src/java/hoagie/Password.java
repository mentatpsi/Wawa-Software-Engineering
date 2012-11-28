
package hoagie;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Password implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String userName;
    String password;

    //getters
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    //constructors
    public Password() {
    }

    public Password(String userName, String pass) {
        this.userName = userName;
        this.password = pass; 
    }
    
}
