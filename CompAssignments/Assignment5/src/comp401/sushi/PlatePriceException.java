package comp401.sushi;

public class PlatePriceException extends Exception {

	public PlatePriceException() {
		super("Contents of plate can not cost more than price of plate");
	}
}
