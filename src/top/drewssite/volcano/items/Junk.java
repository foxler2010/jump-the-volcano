package top.drewssite.volcano.items;

/**
 * The Junk class is the "default" subclass of Priceable.
 * It does not add anything new, unlike the other subclasses of Priceable.
 * These items are not supposed to be worth much, and an important characteristic of them is that
 * you can find them when dumpster diving.
 * @author foxler2010
 * @since v1.0
 * @see Priceable
 */
public final class Junk extends Priceable {
	
	/**
	 * The constructor for the Junk class
	 * @param name The name of the Junk item
	 * @param price The price of the item
	 */
	public Junk(String name, double price) {
		super(name, ItemType.JUNK, price, false);
	}

}
