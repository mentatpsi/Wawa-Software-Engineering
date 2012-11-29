package hoagie;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Password implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private String userName;
    private String password;
    private Integer attempts;  //unsuccessful login attempts

    
    public Password(){
        
    }

    public Password(String userName, String pass) {
        this.userName = userName;
        this.password = pass;
        this.attempts = 0;
    }
    
    public String getPassword() {
        return this.password;
    }
    
}
