package comp401.sushi;

/**
 *  Common interface for sushi ingredients
 * @author KMP
 *
 */

public interface Ingredient {
	/**
	 * Standard getter for the amount of ingredient
	 * @return the amount in unit ounce.
	 */
    double getAmount();
    /**
     * Standard getter for the cost of ingredient.
     * @return the cost of the ingredient.
     */
    double getCost();
    /**
     * Standard boolean getter.
     * @return whether the ingredient is rice.
     */
    boolean isRice();
    /**
     * Standard boolean getter.
     * @return whether the ingredient is shellfish.
     */
    boolean isShellfish();
    /**
     *Standard boolean getter.
     * @return whether the ingredient is vegetarian.
     */
    boolean isVegetarian();
    /**
     * Standard getter for the name of the ingredient. 
     * @return the name of the ingredient.
     */
    String getName();
}
