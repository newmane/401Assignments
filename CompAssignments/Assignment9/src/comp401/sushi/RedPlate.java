package comp401.sushi;

public class RedPlate extends PlateImpl {

	public RedPlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.RED, contents, 1.0);
	}
}
