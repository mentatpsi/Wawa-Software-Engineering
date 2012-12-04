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

/**
 *
 * @author g0D
 */
@Entity
public class HoagieMap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int hoagie_id;
    private int ingredient_id;
    private int quantity;

    public HoagieMap(){
        
    }
    
    public HoagieMap(int hid, int ingred_id, int quantity){
        this.hoagie_id = hid;
        this.ingredient_id = ingred_id;
        this.quantity = quantity;
    }
    
    public int getHoagie_id() {
        return hoagie_id;
    }

    public void setHoagie_id(int hoagie_id) {
        this.hoagie_id = hoagie_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof HoagieMap)) {
            return false;
        }
        HoagieMap other = (HoagieMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hoagie.HoagieMap[ id=" + id + " ]";
    }
    
}
