package a3jedi;

import java.util.*;

public class Roll implements Sushi {
	private Ingredient[] roll_ingredients;

	public Roll(Ingredient[] roll_ingredients) {

		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				throw new RuntimeException("Ingredient not valid");
			}

		}

		Ingredient[] new_ingredients = removeRepeats(roll_ingredients);
		this.roll_ingredients = checkSeaweed(new_ingredients);
	}

	/*
	 * This combines repeated ingredients that takes in an array of ingredients
	 * and returns an array of ingredients without repeats
	 */
	public static Ingredient[] removeRepeats(Ingredient[] roll_ingredients) {
		ArrayList<Ingredient> roll_ingredients_fixed = new ArrayList<Ingredient>();
		Ingredient[] roll_ingredients_clone = roll_ingredients.clone();

		for (int i = 0; i < roll_ingredients_clone.length; i++) {
			boolean alreadyincluded = false;

			for (Ingredient k : roll_ingredients_fixed) {
				if (k.getName().equals(roll_ingredients_clone[i].getName())) {
					alreadyincluded = true;
				}
			}

			Ingredient combinedrepeats = roll_ingredients_clone[i];

			if (!alreadyincluded) {
				double new_amount = roll_ingredients_clone[i].getAmount();
				for (int j = i + 1; j < roll_ingredients_clone.length; j++) {
					if ((roll_ingredients_clone[i].getName())
							.equals((roll_ingredients_clone[j].getName()))) {
						new_amount += roll_ingredients_clone[j].getAmount();
					}
				}

				if (roll_ingredients_clone[i].getName().equals("avocado")) {
					combinedrepeats = new Avocado(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals("crab")) {
					combinedrepeats = new Crab(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals("eel")) {
					combinedrepeats = new Eel(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals("rice")) {
					combinedrepeats = new Rice(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals("salmon")) {
					combinedrepeats = new Salmon(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals(
						"seaweeed")) {
					combinedrepeats = new Seaweed(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals("shrimp")) {
					combinedrepeats = new Shrimp(new_amount);
				} else if (roll_ingredients_clone[i].getName().equals("tuna")) {
					combinedrepeats = new Tuna(new_amount);
				}
				roll_ingredients_fixed.add(combinedrepeats);
			}
		}
		Ingredient[] my_fixed_array = new Ingredient[roll_ingredients_fixed
				.size()];
		my_fixed_array = roll_ingredients_fixed.toArray(my_fixed_array);
		return my_fixed_array;
	}

	/*
	 * This assures that the seaweed wrapper is included and its amount is .1
	 * ounces it takes in an array of ingredients and returns an array of
	 * ingredients with the appropriate amount of seaweed
	 */
	public static Ingredient[] checkSeaweed(Ingredient[] roll_ingredients) {
		Ingredient[] roll_ingredients_clone = roll_ingredients.clone();
		boolean hasSeaweed = false;

		for (int i = 0; i < roll_ingredients_clone.length; i++) {
			if (roll_ingredients_clone[i].getName().equals("seaweed")) {
				if (roll_ingredients_clone[i].getAmount() >= .1) {
					hasSeaweed = true;
				} else {
					Ingredient ingredient = new Seaweed(.1);
					roll_ingredients_clone[i] = ingredient;
					hasSeaweed = true;
				}
			}
		}

		if (!hasSeaweed) {
			Ingredient[] roll_ingredients_with_seaweed = new Ingredient[roll_ingredients_clone.length + 1];

			for (int i = 0; i < roll_ingredients_clone.length; i++) {
				roll_ingredients_with_seaweed[i] = roll_ingredients_clone[i];
			}

			roll_ingredients_with_seaweed[roll_ingredients_clone.length] = new Seaweed(
					0.1);
			return roll_ingredients_with_seaweed;
		} else {
			return roll_ingredients_clone;
		}
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
