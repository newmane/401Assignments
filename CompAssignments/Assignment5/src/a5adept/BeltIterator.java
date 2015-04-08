package a5adept;

import java.util.Iterator;

import comp401.sushi.*;

import java.util.NoSuchElementException;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int start_position;
	private int cur_idx;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = start_position;
		this.cur_idx = start_position;
	}

	public boolean hasNext() {
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				return true;
			}
		}
		return false;
	}

	public Plate next() {
		if (hasNext() == true) {
			for (int i = 0; i < belt.getSize(); i++) {
				int j = cur_idx + i;
				Plate newplate = belt.getPlateAtPosition(j);
				if(newplate != null) {
					cur_idx = (j + 1) % belt.getSize();
					return newplate;
				}
			}
		} else {
			throw new NoSuchElementException();
		}
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
