package a7jedi;

import java.util.Observable;
import java.util.Observer;
import comp401.sushi.*;

public class SpoilageCollector implements Observer {

	private double totalSpoiledCost;
	private double totalSpoiledShellfish;
	private double totalSpoiledSeafood;
	private double totalSpoiledFood;

	public SpoilageCollector() {
	}

	public void update(Observable o, Object arg) {
		PlateEvent plate_event = (PlateEvent) arg;
		Belt belt = (Belt) o;
		if (plate_event.getType().equals(PlateEvent.EventType.PLATE_SPOILED)) {

			totalSpoiledCost += plate_event.getPlate().getContents().getCost();

			Ingredient[] ingredients = plate_event.getPlate().getContents()
					.getIngredients();

			for (int i = 0; i < ingredients.length; i++) {
				totalSpoiledFood += ingredients[i].getAmount();
				if (ingredients[i].isShellfish()) {
					totalSpoiledShellfish += ingredients[i].getAmount();
				}
				if (!ingredients[i].isVegetarian()) {
					totalSpoiledSeafood += ingredients[i].getAmount();
				}
			}
			belt.removeSpoiledAtPosition(plate_event.getPosition());
		}
	}

	public double getTotalSpoiledCost() {
		return totalSpoiledCost;
	}

	public double getTotalSpoiledShellfish() {
		return totalSpoiledShellfish;
	}

	public double getTotalSpoiledSeafood() {
		return totalSpoiledSeafood;
	}

	public double getTotalSpoiledFood() {
		return totalSpoiledFood;
	}

}
