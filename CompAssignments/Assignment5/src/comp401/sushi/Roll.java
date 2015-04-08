package comp401.sushi;

public class Roll implements Sushi {

	Ingredient[] ingredients;
	
	public Roll(Ingredient[] roll_ingredients) {
		ingredients = roll_ingredients.clone();
	}
	
	@Override
	public Ingredient[] getIngredients() {
		return ingredients.clone();
	}

	@Override
	public double getCost() {
		double cost = 0;
		for (Ingredient i : ingredients) {
			cost += i.getCost();
		}
		return cost;
	}

	@Override
	public boolean hasRice() {
		for (Ingredient i : ingredients) {
			if (i.isRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasShellfish() {
		for (Ingredient i : ingredients) {
			if (i.isShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isVegetarian() {
		for (Ingredient i : ingredients) {
			if (!i.isVegetarian()) {
				return false;
			}
		}
		return true;
	}

}
