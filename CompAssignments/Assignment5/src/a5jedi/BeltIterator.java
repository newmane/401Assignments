package a5jedi;

import java.util.Iterator;
import comp401.sushi.*;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int cur_idx;
	private double max_price;
	private Plate.Color color;
	private boolean remove_avail = false;

	private enum BeltType {
		REGULAR, PRICE, COLOR
	};

	private BeltType belt_type;


	//checks to see if a given place is the right cost or price//
	private boolean beltTypeCheck(Plate plate) {
		boolean check = false;
		if (plate == null) {
			return false;
		}
		switch (belt_type) {
		case REGULAR:
			check = true;
			break;
		case COLOR:
			if (plate.getColor().equals(color)) {
				check = true;
			} 
			break;
		case PRICE:
			if (plate.getPrice() <= max_price) {
				check = true;
			}
			break;
		}
		return check;
	}

	public BeltIterator(Belt belt, int start_position) {
		belt_type = BeltType.REGULAR;
		this.belt = belt;
		this.cur_idx = start_position;
	}

	public BeltIterator(Belt belt, int start_position, double max_price) {
		belt_type = BeltType.PRICE;
		this.belt = belt;
		this.cur_idx = start_position;
		this.max_price = max_price;
	}

	public BeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		belt_type = BeltType.COLOR;
		this.belt = belt;
		this.cur_idx = start_position;
		this.color = color_filter;
	}

	public boolean hasNext() {
		Plate newplate = belt.getPlateAtPosition(cur_idx);
		if (beltTypeCheck(newplate)) {
			return true;
		} else {
			for (int i = 0; i < belt.getSize(); i++) {
				Plate newestplate = belt.getPlateAtPosition(cur_idx + i);
				if (beltTypeCheck(newestplate)) {
					cur_idx += i;
					return true;
				}
			}
		}
		return false;
	}

	public Plate next() {
		if (hasNext() == true) {
			for (int i = 0; i < belt.getSize(); i++) {
				int j = cur_idx + i;
				Plate newplate = belt.getPlateAtPosition(j);
				if(beltTypeCheck(newplate)) {
					cur_idx = (j + 1) % belt.getSize(); 
					remove_avail = true;
					return newplate;
				}
			}
		} else {
			throw new NoSuchElementException();
		}
		return null;
	}

	public void remove() {
		if (remove_avail == true) {
			cur_idx--;
			belt.removePlateAtPosition(cur_idx);
			remove_avail = false;
		} else {
			throw new IllegalStateException();
		}
	}

}
