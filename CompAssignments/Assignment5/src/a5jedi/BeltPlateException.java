package a5jedi;

import comp401.sushi.*;

public class BeltPlateException extends Exception {

	private int position;
	private Plate plate;
	private Belt belt;

	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
		super("Position is already occupied");
		this.position = position;
		this.plate = plate_to_be_set;
		this.belt = belt;
	}

	public int getPosition() {
		return position;
	}

	public Plate getPlateToSet() {
		return plate;
	}

	public Belt getBelt() {
		return belt;
	}

}
