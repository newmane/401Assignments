package a4;

public class GoldPlate extends PlateImpl {

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(price, Plate.Color.GOLD, contents);

		if (price < 5.0) {
			throw new IllegalArgumentException();
		}
	}
}
