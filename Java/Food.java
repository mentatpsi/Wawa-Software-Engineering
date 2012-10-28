import java.util.ArrayList;

public class Food {
	public Food(String name) {
		this.name = name;
		this.initalize();
	}
	
	
	public void initialize() {
		int[] array = [0,0,0,0,0,0,0,0,0]
		this.nutrition = new Nutrition(array);
	}
	
	public boolean inFood(String name) {
		boolean cur = false;
		for (ingredient : Ingredients) {
			if (ingredient == name) {
				cur = true;
				break;
			}
		}
	}
	
	public void addIngredient(String name) {
		/*Allows for the adding of any ingredient, 
		queries database for nutritional fact using 
		getIngNutrition method*/
		int[] array = this.getIngNutrition(name)
		Ingredients.add(name);
		tempNutrition = new Nutrition(array);
		nutrition = nutrition.add(tempNutrition);
	}
	
	public void removeIngredient(String name) {
		/*Allows for the removing of any ingredient 
		in food, queries database for nutritional fact 
		using getIngNutrition method*/
		assert inFood(name);
		int index;
		int[] array = getIngNutrition(name);
		tempNutrition = new Nutrition(array);
		nutrition = nutrition.sub(tempNutrition);
		Ingredients.remove(name);

	}
	
	public int[] getIngNutrition(String name) {
		/* Run Mysql Query, create view for all nutritional 
		facts under ingredient with name: "name"
		*/
		
		int[] result;
		return result;
	
	}


	public Nutrition nutrition;
	public ArrayList Ingredients;


}