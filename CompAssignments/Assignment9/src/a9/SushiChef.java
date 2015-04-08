package a9;

import comp401.sushi.Plate;

public interface SushiChef {
	
	String getName();
	int getPID();
	Plate makePlate();
	void observePurchase(String customer, Plate plate, int chef_pid);
	void observeSpoilage(Plate plate, int chef_pid);
	double getOutstandingCost();
	double getProfit();

}

