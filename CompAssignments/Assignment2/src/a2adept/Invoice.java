package a2adept;
import java.util.*;

public class Invoice {
	private String customer; 
	private ArrayList<InvoiceItem> InvoiceItems;
	
	public Invoice (String customer) {
		this.customer = customer;
		this.InvoiceItems = new ArrayList<InvoiceItem>();
	}
	public String getCustomer() {
		return customer;
	}
	public double getTotalCost() {
		double total_cost = 0;
		for(int i=0; i<InvoiceItems.size(); i++){
			total_cost += InvoiceItems.get(i).getCost();
		}
		return total_cost;
	}
	public InvoiceItem findItemByName(String name) {
		for(int i=0; i<InvoiceItems.size(); i++) {
		if(InvoiceItems.get(i).getName().equals(name)) {
			return InvoiceItems.get(i);
		} 
		}
		return null;
		}
	public InvoiceItem removeFromInvoice(String name) {
		
		InvoiceItem a = findItemByName(name);
		if(a != null){
			InvoiceItems.remove(a);
			return a;
		} else {
			return null;
		}
	}
	public void addToInvoice(InvoiceItem new_item) {
		double price_per_unit;
		int unit_count;
		double total_cost;
		InvoiceItem item = removeFromInvoice(new_item.getName());
			if(item != null) {
			total_cost = item.getCost() + new_item.getCost();
			unit_count = item.getUnitCount() + new_item.getUnitCount();
			price_per_unit = total_cost/unit_count;
			InvoiceItem together =  new InvoiceItem(item.getName(), price_per_unit, unit_count);
			InvoiceItems.add(together);
			} else {
		InvoiceItems.add(new_item);}

	}
}
	
