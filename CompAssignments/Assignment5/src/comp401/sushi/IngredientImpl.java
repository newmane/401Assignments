package comp401.sushi;

public class IngredientImpl implements Ingredient {

	private double amount;
	private double price_per_ounce;
	private String name;
	private boolean is_rice;
	private boolean is_shellfish;
	private boolean is_vegetarian;
	
	protected IngredientImpl(double amount,
							 double price_per_ounce,
							 boolean is_rice,
							 boolean is_shellfish,
							 boolean is_vegetarian,
							 String name) {
		if (amount <= 0) {
			throw new RuntimeException("Illegal amount of ingredient");
		}
		
		this.amount = amount;
		this.price_per_ounce = price_per_ounce;
		this.is_rice = is_rice;
		this.is_shellfish = is_shellfish;
		this.is_vegetarian = is_vegetarian;
		this.name = name;
	}
	
	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public double getCost() {
		return amount * price_per_ounce;
	}

	@Override
	public boolean isRice() {
		return is_rice;
	}

	@Override
	public boolean isShellfish() {
		return is_shellfish;
	}

	@Override
	public boolean isVegetarian() {
		return is_vegetarian;
	}

	@Override
	public String getName() {
		return name;
	}

}
