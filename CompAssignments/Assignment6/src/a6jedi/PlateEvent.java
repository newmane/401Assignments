package a6jedi;

import comp401.sushi.Plate;

public class PlateEvent {

	public enum EventType {
		PLATE_PLACED, PLATE_REMOVED
	};

	private EventType type;
	private Plate plate;
	private int position;

	public PlateEvent(EventType type, Plate plate, int position) {
		this.type = type;
		this.plate = plate;
		this.position = position;
	}

	public EventType getType() {
		return type;
	}

	public Plate getPlate() {
		return plate;
	}

	public int getPosition() {
		return position;
	}

}
