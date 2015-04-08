package a7adept;

import comp401.sushi.Plate;
import comp401.sushi.PlatePriceException;
import comp401.sushi.Sushi;

public class DecoratedPlateImpl implements DecoratedPlate {

	private Plate plate;
	private int age;

	public DecoratedPlateImpl(Plate plate, int age) {
		this.plate = plate;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public Sushi getContents() {
		return plate.getContents();
	}

	@Override
	public Sushi removeContents() {
		return plate.removeContents();
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		plate.setContents(s);
	}

	@Override
	public boolean hasContents() {
		return (plate.getContents() != null);
	}

	@Override
	public double getPrice() {
		return plate.getPrice();
	}

	@Override
	public Color getColor() {
		return plate.getColor();
	}

	@Override
	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		} else {
			return getPrice() - plate.getContents().getCost();
		}
	}

	public Plate getWrappedPlate() {
		return plate;
	}

}
