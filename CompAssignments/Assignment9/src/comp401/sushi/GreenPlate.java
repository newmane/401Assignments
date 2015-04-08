package comp401.sushi;

public class GreenPlate extends PlateImpl {

	public GreenPlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.GREEN, contents, 2.0);
	}
}
