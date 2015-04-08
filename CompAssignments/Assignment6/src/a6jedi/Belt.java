package a6jedi;

import java.util.NoSuchElementException;

import comp401.sushi.*;

public class Belt extends java.util.Observable {

	private Plate[] belt;
	private Customer[] customers;

	public Belt(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Illegal belt size");
		}

		belt = new Plate[size];
		customers = new Customer[size];
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		return belt[correct_position(position)];
	}

	public void setPlateAtPosition(Plate plate, int position)
			throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} else {
			belt[correct_position(position)] = plate;
			setChanged();
			notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_PLACED,
					plate, position));
		}
	}

	public void clearPlateAtPosition(int position) {
		Plate plate_to_be_cleared = belt[correct_position(position)];
		if (plate_to_be_cleared != null) {
			setChanged();
			notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_REMOVED,
					plate_to_be_cleared, position));
		}
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
		Plate last_plate = belt[getSize() - 1];
		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last_plate;
		setChanged();
		for (int i = 0; i < customers.length; i++) {
			if (this.getPlateAtPosition(i) != null) {
				if (customers[i] != null) {
					customers[i].observePlateOnBelt(this,
							getPlateAtPosition(i), i);
				}
			}
		}
	}

	private int correct_position(int position) {
		if (position < 0) {
			return ((position % getSize()) + getSize()) % getSize();
		}
		return position % getSize();
	}

	public void registerCustomerAtPosition(Customer c, int position) {
		if (customers[position] != null) {
			throw new RuntimeException();
		} else {
			for (int i = 0; i < customers.length; i++) {
				if (customers[i] == c) {
					throw new RuntimeException();
				}
			}
		}
		customers[position] = c;
	}

	public Customer unregisterCustomerAtPosition(int position) {
		if (customers[position] == null) {
			return null;
		} else {
			Customer customer_to_unregister = customers[position];
			customers[position] = null;
			return customer_to_unregister;
		}
	}
}
