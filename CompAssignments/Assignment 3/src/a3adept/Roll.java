package a3adept;

public class Roll implements Sushi {
	private Ingredient[] roll_ingredients;

	public Roll(Ingredient[] roll_ingredients) {
		this.roll_ingredients = roll_ingredients;
	}

	public Ingredient[] getIngredients() {
		return roll_ingredients;
	}

	public double getCost() {
		double cost = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			cost += roll_ingredients[i].getCost();
		}
		return cost;
	}

	public boolean hasRice() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].isRice() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean hasShellfish() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].isShellfish() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean isVegetarian() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].isVegetarian() == false) {
				return false;
			}
		}
		return true;
	}

}
