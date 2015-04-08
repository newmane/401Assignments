package a4;

public class IngredientImpl implements Ingredient {
	private double amount;
	private double price;
	private String name;
	private boolean Rice;
	private boolean Shellfish;
	private boolean Vegetarian;

	IngredientImpl(double amount, double price, String name, boolean Rice,
			boolean Shellfish, boolean Vegetarian) {
		this.amount = amount;
		this.price = price;
		this.name = name;
		this.Rice = Rice;
		this.Shellfish = Shellfish;
		this.Vegetarian = Vegetarian;

		if (amount <= 0) {
			throw new RuntimeException(
					"Amount specified is less than or equal to 0");
		}

	}

	public double getAmount() {
		return amount;
	}

	public double getCost() {
		return amount * price;
	}

	public boolean isRice() {
		return Rice;
	}

	public boolean isShellfish() {
		return Shellfish;
	}

	public boolean isVegetarian() {
		return Vegetarian;
	}

	public String getName() {
		return name;
	}

}
