package a6adept;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.Plate;

public class PlateCounter implements Observer {

	private int redPlateCount;
	private int greenPlateCount;
	private int bluePlateCount;
	private int goldPlateCount;

	public PlateCounter() {
	}

	public void update(Observable o, Object arg) {
		PlateEvent plate_event = (PlateEvent) arg;

		if (plate_event.getType().equals(PlateEvent.EventType.PLATE_PLACED)) {
			if (plate_event.getPlate().getColor().equals(Plate.Color.RED)) {
				redPlateCount++;
			}
			if (plate_event.getPlate().getColor().equals(Plate.Color.GREEN)) {
				greenPlateCount++;
			}
			if (plate_event.getPlate().getColor().equals(Plate.Color.BLUE)) {
				bluePlateCount++;
			}
			if (plate_event.getPlate().getColor().equals(Plate.Color.GOLD)) {
				goldPlateCount++;
			}
		} else {
			if (plate_event.getPlate().getColor().equals(Plate.Color.RED)) {
				redPlateCount--;
			}
			if (plate_event.getPlate().getColor().equals(Plate.Color.GREEN)) {
				greenPlateCount--;
			}
			if (plate_event.getPlate().getColor().equals(Plate.Color.BLUE)) {
				bluePlateCount--;
			}
			if (plate_event.getPlate().getColor().equals(Plate.Color.GOLD)) {
				goldPlateCount--;
			}
		}
	}

	public int getRedPlateCount() {
		return redPlateCount;
	}

	public int getGreenPlateCount() {
		return greenPlateCount;
	}

	public int getBluePlateCount() {
		return bluePlateCount;
	}

	public int getGoldPlateCount() {
		return goldPlateCount;
	}
}
