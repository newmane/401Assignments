package comp401.sushi;

public class BluePlate extends PlateImpl {

	public BluePlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.BLUE, contents, 4.0);
	}
}
