/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wawafoods;


import java.io.Serializable;
import javax.persistence.*;
 
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id @GeneratedValue
    private long id;
 
    private String username;
    private String password;
 
    public User() {
    }
 
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
 
    public Long getId() {
        return id;
    }
 
    public String getUn() {
         return username;
    }
 
    public String getPassword() {
         return password;
    }
 
    @Override
    public String toString() {
        return String.format("(%s, %s)", this.username, this.password);
    }
}
