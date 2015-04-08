package a5jedi;

public class BeltFullException extends Exception {

	private Belt belt;

	public BeltFullException(Belt belt) {
		super("Belt is Full");
		this.belt = belt;
	}

	public Belt getBelt() {
		return belt;
	}

}
