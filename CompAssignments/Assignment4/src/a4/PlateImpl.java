package a4;

public class PlateImpl implements Plate {

	private double price;
	private Plate.Color color;
	private Sushi contents;

	PlateImpl(double price, Plate.Color color, Sushi contents)
			throws PlatePriceException {
		this.price = price;
		this.color = color;
		this.contents = contents;
		if (contents != null && contents.getCost() >= price) {
			throw new PlatePriceException(price);
		}
	}

	public Sushi getContents() {
		if (contents == null) {
			return null;
		}
		return contents;
	}

	public Sushi removeContents() {
		Sushi removedcontents;
		if (contents == null) {
			return null;
		} else {
			removedcontents = contents;
			contents = null;
			return removedcontents;
		}
	}

	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		double profit = price - s.getCost();
		if (profit <= 0.0) {
			throw new PlatePriceException(price);
		}
		contents = s;
	}

	public boolean hasContents() {
		if (contents == null) {
			return false;
		} else {
			return true;
		}
	}

	public double getPrice() {
		return price;
	}

	public Plate.Color getColor() {
		return color;
	}

	public double getProfit() {
		if (contents == null) {
			return 0.0;
		} else {
			double difference = price - contents.getCost();
			return difference;
		}
	}

}
