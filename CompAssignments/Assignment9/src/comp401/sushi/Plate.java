package comp401.sushi;


public interface Plate {
	public enum Color {RED, GREEN, BLUE, GOLD}

	public Sushi getContents();

	public Sushi removeContents();

	public void setContents(Sushi s) throws PlatePriceException;

	public boolean hasContents();

	public double getPrice();

	public Color getColor();

	public double getProfit();

}