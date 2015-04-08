package a3jedi;

public class Sashimi implements Sushi {

	public enum SashimiType {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	};

	private Ingredient ingredient;

	public Sashimi(SashimiType type) {
		if (type == SashimiType.TUNA) {
			this.ingredient = new Tuna(.75);
		}

		if (type == SashimiType.SALMON) {
			this.ingredient = new Salmon(.75);
		}

		if (type == SashimiType.EEL) {
			this.ingredient = new Eel(.75);
		}

		if (type == SashimiType.CRAB) {
			this.ingredient = new Crab(.75);
		}

		if (type == SashimiType.SHRIMP) {
			this.ingredient = new Shrimp(.75);
		}

	}

	public Ingredient[] getIngredients() {
		Ingredient[] ingredient_array = { ingredient };
		return ingredient_array;
	}

	public double getCost() {
		return ingredient.getCost();
	}

	public boolean hasRice() {
		return ingredient.isRice();
	}

	public boolean hasShellfish() {
		return ingredient.isShellfish();
	}

	public boolean isVegetarian() {
		return ingredient.isVegetarian();
	}

}
