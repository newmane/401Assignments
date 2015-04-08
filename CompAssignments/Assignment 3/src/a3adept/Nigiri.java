package a3adept;

public class Nigiri implements Sushi {
	public enum NigiriType {
		TUNA, SALMON, EEL, CRAB, SHRIMP
	};

	private Ingredient[] ingredients;

	public Nigiri(NigiriType type) {
		ingredients = new Ingredient[2];

		if (type == NigiriType.TUNA) {
			ingredients[0] = new Tuna(.75);
		}
		if (type == NigiriType.SALMON) {
			ingredients[0] = new Salmon(.75);
		}
		if (type == NigiriType.EEL) {
			ingredients[0] = new Eel(.75);
		}
		if (type == NigiriType.CRAB) {
			ingredients[0] = new Crab(.75);
		}
		if (type == NigiriType.SHRIMP) {
			ingredients[0] = new Shrimp(.75);
		}

		ingredients[1] = new Rice(.5);
	}

	public Ingredient[] getIngredients() {
		return ingredients;
	}

	public double getCost() {
		double cost = 0;
		for (int i = 0; i < ingredients.length; i++) {
			cost += ingredients[i].getCost();
		}
		return cost;
	}

	public boolean hasRice() {
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].isRice() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean hasShellfish() {
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].isShellfish() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean isVegetarian() {
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i].isVegetarian() == false) {
				return false;
			}
		}
		return true;
	}

}
