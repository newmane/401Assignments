package a7jedi;

import java.util.NoSuchElementException;
import comp401.sushi.*;

public class Belt extends java.util.Observable {

	private DecoratedPlate[] belt;
	private int counter;

	public Belt(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Illegal belt size");
		}

		belt = new DecoratedPlate[size];
		counter = 0;
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		if (belt[correct_position(position)] == null) {
			return null;
		} else {
			return belt[correct_position(position)].getWrappedPlate();
		}
	}

	public void setPlateAtPosition(Plate plate, int position)
			throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} else {
			DecoratedPlate decoratedplate = new DecoratedPlateImpl(plate,
					counter);
			belt[correct_position(position)] = decoratedplate;
			setChanged();
			notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_PLACED,
					plate, position));
		}
	}

	public void clearPlateAtPosition(int position) {
		DecoratedPlate plate_to_be_cleared = belt[correct_position(position)];
		if (plate_to_be_cleared != null) {
			setChanged();
			notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_REMOVED,
					plate_to_be_cleared.getWrappedPlate(), position));
		}
		belt[correct_position(position)] = null;
	}

	public void removeSpoiledAtPosition(int position) {
		belt[correct_position(position)] = null;
	}

	public Plate removePlateAtPosition(int position) {
		Plate plate_at_position = getPlateAtPosition(position);
		if (plate_at_position == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(position);
		return plate_at_position;
	}

	public int setPlateNearestToPosition(Plate plate, int position)
			throws BeltFullException {
		for (int offset = 0; offset < getSize(); offset++) {
			try {
				setPlateAtPosition(plate, position + offset);
				return position + offset;
			} catch (BeltPlateException e) {
			}
		}
		throw new BeltFullException(this);
	}

	public void rotate() {
		DecoratedPlate last_plate = belt[getSize() - 1];
		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last_plate;

		counter++;

		for (int i = 0; i < belt.length; i++) {
			if (isPlateSpoiledAtPosition(i)) {
				setChanged();
				notifyObservers(new PlateEvent(
						PlateEvent.EventType.PLATE_SPOILED,
						getPlateAtPosition(i), i));
			}
		}
	}

	private int correct_position(int position) {
		if (position < 0) {
			return ((position % getSize()) + getSize()) % getSize();
		}
		return position % getSize();
	}

	public int getAgeOfPlateAtPosition(int position) {
		if (belt[position] == null) {
			return -1;
		} else {
			return counter - belt[position].getAge();
		}
	}

	private boolean isPlateSpoiledAtPosition(int i) {
		boolean spoiled = false;
		DecoratedPlate plate = belt[i];
		int age = getAgeOfPlateAtPosition(i);

		if (plate != null) {

			Sushi sushi = plate.getWrappedPlate().getContents();
			
			if(sushi != null) {
				if (age >= 3 * belt.length) {
					spoiled = true;
				}
				if (sushi.hasShellfish() == true) {
					if (age >= belt.length) {
						spoiled = true;
					}
				}
				if (!sushi.isVegetarian()) {
					if (age >= 2 * belt.length) {
						spoiled = true;
					}
				}
			}
		}
		return spoiled;
	}

}
