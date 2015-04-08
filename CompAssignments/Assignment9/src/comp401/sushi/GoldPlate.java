package comp401.sushi;

public class GoldPlate extends PlateImpl {

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(Plate.Color.GOLD, contents, price);
		
		if (price < 5.00) {
			throw new IllegalArgumentException("Gold plate price must be greater than or equal to 5.0");
		}
	}
}
