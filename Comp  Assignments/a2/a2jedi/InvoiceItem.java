package a2jedi;

public class InvoiceItem {
	private String name;
	private double price_per_unit;
	private int unit_count;
	
	public InvoiceItem(String name, double price_per_unit, int unit_count){
	this.name = name.trim();
	this.price_per_unit = price_per_unit;
	this.unit_count = unit_count;
	
	if(price_per_unit<=0) {
		throw new RuntimeException("Illegal invoice item");
	}
	if(unit_count<=0) {
		throw new RuntimeException("Illegal invoice item");
	}
	for(int i=0; i<name.length(); i++) {
	if(!Character.isLetterOrDigit(name.charAt(i))) {
		throw new RuntimeException("Illegal invoice item");
	}
	}
	if(!Character.isUpperCase(name.charAt(0))) {
		throw new RuntimeException("Illegal invoice item");
	}
	if(name.equals(null)) {
		throw new RuntimeException("Illegal invoice item");
	}
	}
	public String getName() {
		return name;
	}
	public double getPricePerUnit() {
		return price_per_unit;
	}
	public int getUnitCount() {
		return unit_count;	
	}
	public double getCost() {
		return price_per_unit * unit_count;
	}
	//public static void main(String[] args) {
		//InvoiceItem test = new InvoiceItem("Apple",1.7,2);
		//System.out.println(test.getName());
		//System.out.println(test.getPricePerUnit());
		//System.out.println(test.getUnitCount());
		//System.out.println(test.getCost());
	//}
}