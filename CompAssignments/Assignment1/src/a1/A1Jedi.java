package a1;

import java.util.Scanner;
import java.util.HashMap;

public class A1Jedi {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
	}
	
public static void process(Scanner s) {
	String name = s.next();
	double cost = 0;
	
	HashMap<String, Integer> count = new HashMap<String, Integer>();
	HashMap<String, Double> costs = new HashMap<String, Double>();
	
	while(!name.equals("end")) {
		int quantity = s.nextInt();
		double price = s.nextDouble();
		cost = quantity*price;
		if(count.containsKey(name)) {
			count.put(name, count.get(name) + quantity);				
		}
		else {
			count.put(name, quantity);
		}
		if(costs.containsKey(name)) {
			costs.put(name, costs.get(name) + cost);
		}
		else {
			costs.put(name, cost);
		}
		name = s.next();
	}
	
	int largest_quantity =0;
	String largest_quantity_name = null;
	double largest_cost = 0;
	String largest_cost_name= null;
	double average_cost = 0;
	double largest_average_cost = 0;
	String largest_average_cost_name = null;
	
	for(String var: count.keySet())	{
		int quantity1 = count.get(var);
		double cost1 = costs.get(var);
		average_cost = cost1/quantity1;
		if(quantity1 > largest_quantity) {
			largest_quantity = quantity1;
			largest_quantity_name = var;
		}
		if(cost1 > largest_cost) {
			largest_cost = cost1;
			largest_cost_name = var;
		}
		if(average_cost > largest_average_cost) {
			largest_average_cost = average_cost;
			largest_average_cost_name = var;
		}				
	}
					
	System.out.println("The largest count item with " + largest_quantity + " was: " + largest_quantity_name);
	System.out.println("The largest total cost item at " + largest_cost + " was: " + largest_cost_name);
	System.out.println("The largest average cost item at " + largest_average_cost + " was: " + largest_average_cost_name);
}

}
