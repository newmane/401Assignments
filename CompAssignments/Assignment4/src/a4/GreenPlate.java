package a4;

public class GreenPlate extends PlateImpl {

	public GreenPlate(Sushi contents) throws PlatePriceException {
		super(2.0, Plate.Color.GREEN, contents);
	}

}
