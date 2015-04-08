package comp401.sushi;

public class Nigiri implements Sushi {

	public static final double SEAFOOD_WEIGHT = 0.75;
	public static final double RICE_WEIGHT = 0.5;
	
	public enum NigiriType {TUNA, SALMON, EEL, CRAB, SHRIMP};
	
	private Ingredient seafood;
	private Rice rice;
	
	public Nigiri(NigiriType type) {
		rice = new Rice(RICE_WEIGHT);
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
		return new Ingredient[] {seafood, rice};
	}

	@Override
	public double getCost() {
		return seafood.getCost()+rice.getCost();
	}

	@Override
	public boolean hasRice() {
		return true;
	}

	@Override
	public boolean hasShellfish() {
		return seafood.isShellfish();
	}

	@Override
	public boolean isVegetarian() {
		return false;
	}
}
