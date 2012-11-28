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
 * @author Alan
 */
@Entity
public class HoagieIngredients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int calories;
    private int caloriesFat;
    private int totalFat;
    private int satFat;
    private int monoFat;
    private int polyFat;
    private int transFat;
    private int cholesterol;
    private int sodium;
    private int potassium;
    private int carbs;
    private int fiber;
    private int sugars;
    private int protein;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCaloriesFat() {
        return caloriesFat;
    }

    public void setCaloriesFat(int caloriesFat) {
        this.caloriesFat = caloriesFat;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public int getSatFat() {
        return satFat;
    }

    public void setSatFat(int satFat) {
        this.satFat = satFat;
    }

    public int getMonoFat() {
        return monoFat;
    }

    public void setMonoFat(int monoFat) {
        this.monoFat = monoFat;
    }

    public int getPolyFat() {
        return polyFat;
    }

    public void setPolyFat(int polyFat) {
        this.polyFat = polyFat;
    }

    public int getTransFat() {
        return transFat;
    }

    public void setTransFat(int transFat) {
        this.transFat = transFat;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getSugars() {
        return sugars;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
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

    //constructors
    public HoagieIngredients(){
        
    }
    
    public HoagieIngredients(String name){
        this.name = name;
    }
    
    public HoagieIngredients(String name, int calories, int fatCal,
            int totFat, int satFat, int polyFat, int transFat,
            int cholesterol, int sodium, int potassium,
            int carbs, int fiber, int sugars, int protein){
        
        //store the passed-in vals
        this.name = name;
        this.calories = calories;
        this.caloriesFat = fatCal;
        this.totalFat = totFat;
        this.satFat = satFat;
        this.polyFat = polyFat;
        this.transFat = transFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.potassium = potassium;
        this.carbs = carbs;
        this.fiber = fiber;
        this.sugars = sugars;
        this.protein = protein;
        
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoagieIngredients)) {
            return false;
        }
        HoagieIngredients other = (HoagieIngredients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name:" + name + "<br/>" +
               "Calories: " + calories + "<br/>" +
                "Fat Calories: " + caloriesFat + "<br/>" +
                "Total Fat(g): " + totalFat + "<br/>" +
                "Saturated Fat(g): " + satFat + "<br/>" +
                "Polyunsaturated Fat(g): " + polyFat + "<br/>" +
                "Trans Fat(g): " + transFat + "<br/>" +
                "Cholesterol(g: " + cholesterol + "<br/>" +
                "Sodium(mg): " + sodium + "<br/>" +
                "Potassium(mg): " + potassium + "<br/>" +
                "Carbs(g): " + carbs + "<br/>" +
                "Fiber(g): " + fiber + "<br/>" +
                "Sugars(g): " + sugars + "<br/>" +
                "Protein(g): " + protein + "<br/>";
    }
    
}
