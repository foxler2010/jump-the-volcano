package top.drewssite.volcano.items;

/**
 * The Trophy class is the exact same as Junk, it just has a different name.
 * Trophies need to be differentiated from Junk, so they get their own type.
 * @author foxler2010
 * @since v1.0
 * @see Priceable
 */
public final class Trophy extends Priceable {
	
	/**
	 * The constructor for the Trophy class
	 * @param name The name of the Trophy item
	 * @param price The price of the item
	 */
	public Trophy(String name, double price) {
		super(name, ItemType.TROPHY, price, false);
	}

}
