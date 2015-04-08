package a2jedi;

import java.util.*;

public class Invoice {
	private String customer;
	private ArrayList<InvoiceItem> InvoiceItems;
	private static int invoice_number = 0;
	private int thisnumber;

	public Invoice(String customer) {
		this.customer = customer;
		this.InvoiceItems = new ArrayList<InvoiceItem>();
		invoice_number = invoice_number + 1;
		this.thisnumber = invoice_number;
	}

	public String getCustomer() {
		return customer;
	}

	public double getTotalCost() {
		double total_cost = 0;
		for (int i = 0; i < InvoiceItems.size(); i++) {
			total_cost += InvoiceItems.get(i).getCost();
		}
		return total_cost;
	}

	public InvoiceItem findItemByName(String name) {
		for (int i = 0; i < InvoiceItems.size(); i++) {
			if (InvoiceItems.get(i).getName().equals(name)) {
				return InvoiceItems.get(i);
			}
		}
		return null;
	}

	public InvoiceItem removeFromInvoice(String name) {

		InvoiceItem a = findItemByName(name);
		if (a != null) {
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
		if (item != null) {
			total_cost = item.getCost() + new_item.getCost();
			unit_count = item.getUnitCount() + new_item.getUnitCount();
			price_per_unit = total_cost / unit_count;
			InvoiceItem together = new InvoiceItem(item.getName(),
					price_per_unit, unit_count);
			InvoiceItems.add(together);
		} else {
			InvoiceItems.add(new_item);
		}

	}

	public int getInvoiceNumber() {
		return thisnumber;
	}

	public InvoiceItem[] findItemsByNameFilter(String filter,
			boolean strict_prefix) {
		ArrayList<InvoiceItem> array = new ArrayList<InvoiceItem>();
		if (strict_prefix == true) {
			for (int i = 0; i < InvoiceItems.size(); i++) {
				if (InvoiceItems.get(i).getName().startsWith(filter)) {
					array.add(InvoiceItems.get(i));
				}
			}
		}
		if (strict_prefix == false) {
			for (int i = 0; i < InvoiceItems.size(); i++) {
				if (InvoiceItems.get(i).getName().contains(filter)) {
					array.add(InvoiceItems.get(i));
				}
			}
		}
		InvoiceItem[] my_simple_array = array.toArray(new InvoiceItem[array
				.size()]);
		if(my_simple_array.length == 0) {
			return null;	
		}
		return my_simple_array;
	}

	public Invoice separateByNameFilter(String filter, boolean strict_prefix) {
		Invoice separated = new Invoice(getCustomer());
		InvoiceItem[] filtered = findItemsByNameFilter(filter, strict_prefix);
		if (filtered.length >= 1) {
			for (int i = 0; i < filtered.length; i++) {
				String name = filtered[i].getName();
				separated.addToInvoice(filtered[i]);
				removeFromInvoice(name);
			}
			return separated;
		} else {
			return null;
		}

	}
}
