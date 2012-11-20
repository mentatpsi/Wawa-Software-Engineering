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
    private int cal, fatCal, totFat, satFat, transFat,
            chol, sodium, carb, fiber, sugars, protein, vitA,
            vitC, calcium, iron = 0;

    // Constructors:
    public Ingredients() {
    }
 
    public Ingredients(String name) {
        this.name = name;
    }
 
    public void setAll(int cal, int fatCal, int totFat, int satFat,
            int transFat, int chol, int sodium, int carb, int fiber,
            int sugars, int protein, int vitA, int vitC, int calcium,
            int iron){
        setCal(cal);
        setFatCal(fatCal);
        setTotFat(totFat);
        setSatFat(satFat);
        setTransFat(transFat);
        setChol(chol);
        setSodium(sodium);
        setCarb(carb);
        setFiber(fiber);
        setSugars(sugars);
        setProtein(protein);
        setVitA(vitA);
        setVitC(vitC);
        setCalcium(calcium);
        setIron(iron);
    }
    public void setCal(int cal){
        this.cal = cal;
    }
    public void setFatCal(int fatCal){
        this.fatCal = fatCal;
    }
    public void setTotFat(int totFat){
        this.totFat = totFat;
    }
    public void setSatFat(int satFat){
        this.satFat = satFat;
    }
    public void setTransFat(int transFat){
        this.transFat = transFat;
    }
    public void setChol(int chol){
        this.chol = chol;
    }
     public void setSodium(int sodium){
        this.sodium = sodium;
    }
     public void setCarb(int carb){
        this.carb = carb;
    }
     public void setFiber(int fiber){
        this.fiber = fiber;
    }
    public void setSugars(int sugars){
        this.sugars = sugars;
    }
    public void setProtein(int protein){
        this.protein = protein;
    }
    public void setVitA(int vitA){
        this.vitA = vitA;
    }
    public void setVitC(int vitC){
        this.vitC = vitC;
    }
    public void setCalcium(int calcium){
        this.calcium = calcium;
    }
    public void setIron(int iron){
        this.iron = iron;
    }
    
    // String Representation:
    @Override
    public String toString() {
        return name + "<br/>";
    }
}