package a5adept;

import comp401.sushi.*;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Belt implements Iterable<Plate> {

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
		if (position < 0) {
			position = ((position % size) + size) % size;
		} else {
			position = position % size;
		}
		if (belt_plates[position] == null) {
			return null;
		} else {
			return belt_plates[position];
		}
	}

	public void setPlateAtPosition(Plate plate, int position)
			throws BeltPlateException {
		if (position < 0) {
			position = ((position % size) + size) % size;
		} else {
			position = position % size;
		}
		if (plate == null) {
			throw new IllegalArgumentException();
		}
		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} else {
			belt_plates[position] = plate;
		}
	}

	public void clearPlateAtPosition(int position) {
		if (position < 0) {
			position = ((position % size) + size) % size;
		} else {
			position = position % size;
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

	public int setPlateNearestToPosition(Plate plate, int position)
			throws BeltFullException, BeltPlateException {
		if (getPlateAtPosition(position) == null) {
			setPlateAtPosition(plate, position);
			return position;
		} else {
			for (int i = 1; i < size; i++) {
				if (getPlateAtPosition(i) == null) {
					setPlateAtPosition(plate, i);
					return i;
				}
			}
		}
		throw new BeltFullException(this);
	}

	public Iterator<Plate> iterator() {
		Iterator<Plate> iter = new BeltIterator(this, 0);
		return iter;
	}

	public Iterator<Plate> iteratorFromPosition(int position) {
		Iterator<Plate> iter = new BeltIterator(this, position);
		return iter;
	}

	public void rotate() throws BeltPlateException {
		Plate[] rotated_belt_plates = new Plate[size];
		rotated_belt_plates[0] = getPlateAtPosition(size - 1);
		for (int i = 1; i < size; i++) {
			i = i % size;
			rotated_belt_plates[i] = getPlateAtPosition(i - 1);
		}
		belt_plates = rotated_belt_plates;
	}

}
