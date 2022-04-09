package top.drewssite.volcano;

public class Junk extends Item {
	
	//VAR
	private double price;
	
	
	//GETTER AND SETTER
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	//CONSTRUCTOR
	public Junk(String name, double price) {
		super(name, ItemType.JUNK, false);
		this.price = price;
	}
	public void postConstruction() {
		
		Data.junkItems.add(this); //add to list of all junks

	}
}
