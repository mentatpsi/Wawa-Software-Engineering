public class Nutrition {
	public Nutrition(String[] array) {
			/*Nutrition 
				initializes based on inputting array where elements are:
				[0] - Calories 
				[1] - Total Fat 
				[2] - Saturated Fat 
				[3] - Trans Fat
				[4] - Carbohydrates
				[5] - Sodium
				[6] - Protein
				[7] - Fiber
				[8] - Serving 
			*/
			this.setValues(array);
			this.array = array;
		
	}
	
	public setValues(int[] array) {
		this.setCalories(array[0]);
		this.setTotalFat(array[1]);
		this.setSaturated(array[2]);
		this.setTransFat(array[3]);
		this.setCarbs(array[4]);
		this.setSodium(array[5]);
		this.setProtein(array[6]);
		this.setFiber(array[7]);
		this.setServing(array[8]);
	}
	
	public Nutrition add(Nutrition nun1) {
		int[] newArray;
		for (int i = 0; i < this.array.length ; i++) {
			newArray[i] = this.array[i] + nun1.array[i]
		}
		Nutrition newNun = new Nutrition(newArray);
		return newNun;
	}
	
	public Nutrition sub(Nutrition nun1) {
		int[] newArray;
		for (int i = 0; i < this.array.length ; i++) {
			newArray[i] = this.array[i] - nun1.array[i]
		}
		Nutrition newNun = new Nutrition(newArray);
		return newNun;
	}
	
	public setCalories(int value) {
		this.calories = value;	
	}
	
	public setTotalFat(int value) {
		this.total_fat = value;
	}

	public setSaturated(int value) {
		this.saturated = value;	
	}
	
	public setTransFat(int value) {
		this.transfat = value;
	}

	public setCarbs(int value) {
		this.carbs = value;	
	}
	
	public setSodium(int value) {
		this.sodium = value;
	}
	
	public setProtein(int value) {
		this.carbs = value;	
	}
	
	public setFiber(int value) {
		this.fiber = value;
	}
	
	public setServing(int value) {
		this.serving = value;
	}
	public String createLabel() {
		String curStr = "";
		/*return the html / markup that will make the label
		
		*//
		return curStr;
	
	}
	
	public int[] array;
	public int calories;
	
	public int total_fat;
	public int saturated;
	public int transfat;
	public int carbs;
	
	public int sodium;
	public int protein;
	public int fiber;
	
	public int serving;
}