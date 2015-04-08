package comp401.sushi;

abstract public class PlateImpl implements Plate {
	
	private Plate.Color color;
	private Sushi contents;
	private double price;
	
	public PlateImpl(Plate.Color color, Sushi contents, double price) throws PlatePriceException {
		this.color = color;
		this.contents = null;
		this.price = price;
		
		if (contents != null) {
			setContents(contents);
		}
	}
	
	@Override
	public Sushi getContents() {
		return contents;
	}
	
	@Override
	public Sushi removeContents() {
		Sushi removed_contents = contents;
		contents = null;
		return removed_contents;
	}
	
	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException("Null passed to setContents");
		} else if (s.getCost() >= getPrice()) {
			throw new PlatePriceException();
		}
		contents = s;
	}
	
	@Override
	public boolean hasContents() {
		return (contents != null);
	}
	
	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public Plate.Color getColor() {
		return color;
	}
	
	@Override
	public double getProfit() {
		if (!hasContents()) {
			return 0.0;
		} else {
			return getPrice() - contents.getCost();
		}
	}
}
