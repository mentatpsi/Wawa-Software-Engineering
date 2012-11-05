/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoagie;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Hoagie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //persistent fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;
    private int calories;
    private int fat;
    private int protein;
    private Date signingDate;

    //constructors
    public Hoagie(String name){
        //constructor only requires a name
        this.name = name; 
        this.signingDate = new Date(System.currentTimeMillis());
    }
    
    
            
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoagie)) {
            return false;
        }
        Hoagie other = (Hoagie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  name + "(Hoagie name)" ;
    }
    
}
