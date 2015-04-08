package a4;

public class PlatePriceException extends Exception {

	public PlatePriceException(double price) {
		super("Illegal plate price");
	}

}
