package top.drewssite.volcano.items;

/**
 * This abstract class is the superclass of all classes that have "price" as a property.
 * Originally, these subclasses were extensions of Junk, but now they are subclasses (along with Junk) of Priceable.
 * This provides more clarity as to what they are, since Food, Bottle, and Liquids are not all Junk.
 * @author foxler2010
 * @since v1.0
 * @see Item
 */
public abstract class Priceable extends Item {
	
	//VAR
	private double price;
	
	/**
	 * Returns the price of the item
	 * @return The price of the item
	 * @author foxler2010
	 * @since v1.0
	 * @see Priceable
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price of the item
	 * @param price The new price of the item
	 * @author foxler2010
	 * @since v1.0
	 * @see Priceable
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * The constructor for all items of Priceable descent
	 * @param name The name of the item
	 * @param type The type of the item
	 * @param price The item's price
	 * @param important The importancy of the item
	 * @author foxler2010
	 * @since v1.0
	 * @see Priceable
	 */
	public Priceable(String name, ItemType type, double price, boolean important) {
		super(name, type, important);
		this.price = price;
	}

}
