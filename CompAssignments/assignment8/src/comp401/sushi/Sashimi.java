package comp401.sushi;

public class Sashimi implements Sushi {

	public static final double SEAFOOD_WEIGHT = 0.75;
	
	public enum SashimiType {TUNA, SALMON, EEL, CRAB, SHRIMP};
	
	private Ingredient seafood;
	
	public Sashimi(SashimiType type) {
		switch(type) {
		case TUNA:
			seafood = new Tuna(SEAFOOD_WEIGHT);
			break;
		case SALMON:
			seafood = new Salmon(SEAFOOD_WEIGHT);
			break;
		case EEL:
			seafood = new Eel(SEAFOOD_WEIGHT);
			break;
		case CRAB:
			seafood = new Crab(SEAFOOD_WEIGHT);
			break;
		case SHRIMP:
			seafood = new Shrimp(SEAFOOD_WEIGHT);
			break;
		}
	}
	
	@Override
	public Ingredient[] getIngredients() {
		return new Ingredient[] {seafood};
	}

	@Override
	public double getCost() {
		return seafood.getCost();
	}

	@Override
	public boolean hasRice() {
		return false;
	}

	@Override
	public boolean hasShellfish() {
		return seafood.isShellfish();
	}

	@Override
	public boolean isVegetarian() {
		return false;
	}
	
	@Override
	public String toString() {
		return seafood.getName() + " sashimi";
	}
}
