package top.drewssite.volcano.items;

/**
 * The root class of all Items. Has only three properties, which are shared
 * among all Items:
 * <ul>
 * <li>
 * <p>
 * Name: The name of the Item as displayed to players. Can be changed, and
 * should not be used for identification.
 * </p>
 * </li>
 * <li>
 * <p>
 * Type: The type of the Item. Every instantiable subclass of Item should have a
 * separate enum value in ItemType which should be used for all Items of that
 * type.
 * </p>
 * </li>
 * <li>
 * <p>
 * Important: To my knowledge this is barely used. You would have to look very
 * hard to find a spot where this propety is used. Nevertheless, it is here for
 * when I need it. Maybe at some point it will be removed.
 * </p>
 * </li>
 * </ul>
 * 
 * @author foxler2010
 * @since v1.0
 */
public abstract class Item {

	// VARS
	private String name;
	private ItemType type;
	private boolean important;

	
	
	/** Gets the Item's name.
	 * @return The Item's name
	 * @author foxler2010
	 * @since v1.0
	 * @see Item
	 */
	public String getName() {
		return name;
	}

	
	/** Gets the Item's type.
	 * @return The Item's type
	 * @author foxler2010
	 * @since v1.0
	 * @see Item
	 */
	public ItemType getType() {
		return type;
	}

	
	/** Sets the Item's name
	 * @param name The Item's new name
	 * @author foxler2010
	 * @since v1.0
	 * @see Item
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** Sets the Item's type
	 * @param type The Item's new type
	 * @author foxler2010
	 * @since v1.0
	 * @see Item
	 */
	public void setType(ItemType type) {
		this.type = type;
	}

	
	/** Returns whether the Item is important or not.
	 * @return Whether the Item is important or not
	 * @author foxler2010
	 * @since v1.0
	 * @see Item
	 */
	public boolean isImportant() {
		return important;
	}

	
	/** Sets the Item's importancy
	 * @param important The Item's new importancy
	 * @author foxler2010
	 * @since v1.0
	 * @see Item
	 */
	public void setImportancy(boolean important) {
		this.important = important;
	}

	/**
	 * Constructs a new Item.
	 * @author foxler2010
	 * @param name The name of the Item, as seen by the player
	 * @param type The Item's type. In most cases this should be set in the subclass' constructor
	 * @param important The Item's importancy
	 * @since v1.0
	 * @see Item
	 */
	public Item(String name, ItemType type, boolean important) {
		this.name = name;
		this.type = type;
		this.important = important;
	}

}
