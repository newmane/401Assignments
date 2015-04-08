package comp401.sushi;

public interface Sushi {
	Ingredient[] getIngredients();
	double getCost();
	boolean hasRice();
	boolean hasShellfish();
	boolean isVegetarian();

}
