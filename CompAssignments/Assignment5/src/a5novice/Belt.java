package a5novice;

import comp401.sushi.*;
import java.util.NoSuchElementException;

public class Belt {

	private int size;
	private Plate[] belt_plates;

	public Belt(int size) {
		this.size = size;
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		belt_plates = new Plate[size];
	}

	public int getSize() {
		return size;
	}

	public Plate getPlateAtPosition(int position) {
		if (position < 0 || position > getSize() - 1) {
			throw new IllegalArgumentException();
		}
		if (belt_plates[position] == null) {
			return null;
		} else {
			return belt_plates[position];
		}
	}

	public void setPlateAtPosition(Plate plate, int position)
			throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}
		if (position < 0 || position > getSize() - 1) {
			throw new IllegalArgumentException();
		}
		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} 
		belt_plates[position] = plate;
	}

	public void clearPlateAtPosition(int position) {
		if (position < 0 || position > getSize() - 1) {
			throw new IllegalArgumentException();
		}
		belt_plates[position] = null;
	}

	public Plate removePlateAtPosition(int position) {
		if (getPlateAtPosition(position) == null) {
			throw new NoSuchElementException();
		} else {
			Plate deleted = getPlateAtPosition(position);
			clearPlateAtPosition(position);
			return deleted;
		}
	}

}
