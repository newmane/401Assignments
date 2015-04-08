package a1;

import java.util.Scanner;

public class A1Novice {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	public static void process(Scanner s) {
		int largest_quantity_item = 0;
		String largest_quantity_name = null;
		double largest_cost_item = 0;
		String largest_cost_name = null;
		double total_cost_items =0;
		double average_cost_items =0;
		int total_number =0;
		int items = s.nextInt();
		double cost = 0;
		
		for(int i=0;i<items;i++) {
			String name = s.next();
			int quantity = s.nextInt();
			double price = s.nextDouble();
			cost = quantity*price;
			if(quantity>=largest_quantity_item) {
				largest_quantity_item = quantity;
				largest_quantity_name = name;
				
			}
			if(cost>=largest_cost_item) {
				largest_cost_item = cost;
				largest_cost_name = name;
			}
			total_cost_items += cost;
			total_number += quantity;
			
		}
		average_cost_items = total_cost_items/total_number;
		System.out.println("The largest quantity item was:" + largest_quantity_name);
		System.out.println("The largest cost item was:" + largest_cost_name);
		System.out.println("Total Cost:" + total_cost_items);
		System.out.println("Average Cost:" + average_cost_items);
		
	
	
}


}
