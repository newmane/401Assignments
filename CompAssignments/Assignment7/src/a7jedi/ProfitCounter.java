package a7jedi;

import java.util.Observable;
import java.util.Observer;

public class ProfitCounter implements Observer {

	private double totalBeltProfit;
	private double numberOfPlates;

	public ProfitCounter() {
	}

	public void update(Observable o, Object arg) {
		PlateEvent plate_event = (PlateEvent) arg;

		if (plate_event.getType().equals(PlateEvent.EventType.PLATE_PLACED)) {
			totalBeltProfit += plate_event.getPlate().getProfit();
			numberOfPlates++;
		} else {
			totalBeltProfit -= plate_event.getPlate().getProfit();
			numberOfPlates--;
		}
	}

	public double getTotalBeltProfit() {
		return totalBeltProfit;
	}

	public double getAverageBeltProfit() {
		return totalBeltProfit / numberOfPlates;
	}

}
