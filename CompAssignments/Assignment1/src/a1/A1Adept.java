package a1;

import java.util.Scanner;

public class A1Adept {

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
public static void process(Scanner s) {
	int [] items_for_each_category = new int[10];
	int [] cost_for_each_category = new int[10];
	double cost = 0;
	String name = s.next();
	
	while(!name.equals("end")) {
		int category = s.nextInt();
		int quantity = s.nextInt();
		double price = s.nextDouble();
		cost = quantity*price;
		items_for_each_category[category] += quantity;
		cost_for_each_category[category] += cost;
		name = s.next();
	}
	int most_items = 0;
	int most_items_category = 0;
	int least_items = 1500000;
	int least_items_category = 0;
	double highest_cost = 0;
	int highest_cost_category = 0;
	double lowest_cost = 150000;
	int lowest_cost_category = 0;
	
	for(int i=0;i<10;i++) {
		if(items_for_each_category[i]>most_items) {
			most_items_category = i;
			most_items = items_for_each_category[i];
		}
		if(items_for_each_category[i]<least_items && items_for_each_category[i]>0) {
			least_items_category = i;
			least_items = items_for_each_category[i];
		}
		if(cost_for_each_category[i]>highest_cost) {
			highest_cost_category = i;
			highest_cost = cost_for_each_category[i];
		}
		if(cost_for_each_category[i]< lowest_cost && cost_for_each_category[i]>0) {
			lowest_cost_category = i;
			lowest_cost = cost_for_each_category[i];
		}
	}
	
	System.out.println("Category with most items:" + most_items_category);	
	System.out.println("Category with least items:" + least_items_category);
	System.out.println("Category with largest_cost:" + highest_cost_category);
	System.out.println("Category with least cost:"+ lowest_cost_category);

	}
}
