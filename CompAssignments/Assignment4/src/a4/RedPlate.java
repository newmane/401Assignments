package a4;

public class RedPlate extends PlateImpl {

	public RedPlate(Sushi contents) throws PlatePriceException {
		super(1.0, Plate.Color.RED, contents);
	}

}
