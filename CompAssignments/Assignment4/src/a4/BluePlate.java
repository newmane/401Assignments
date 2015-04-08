package a4;

public class BluePlate extends PlateImpl {

	public BluePlate(Sushi contents) throws PlatePriceException {
		super(4.0, Plate.Color.BLUE, contents);
	}

}
