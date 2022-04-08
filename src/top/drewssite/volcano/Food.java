package top.drewssite.volcano;

/**
 * This class implements the "Food" itemType, allowing the player to eat things. It extends Junk, because Junk already has price implemented.
 * @author foxler2010
 * @since v1.0
 * @see Junk
 * @see Item
 */
public class Food extends Junk {
    
    /**
     * The amount of energy the food provides when eaten.
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
    private int energy;
    private final boolean cookable;
    private boolean cooked;

    /**
     * Returns the amount of energy the food provides.
     * @return The amount of energy the food provides.
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
	public double getEnergy() {
		return energy;
	}
	
    /**
     * Sets the amount of energy the food provides.
     * @param energy The amount of energy the food provides.
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
	public void setEnergy(int energy) {
		this.energy = energy;
	}

    /**
     * Constructs a new instance of Food.
     * @param name The name of the Food
     * @param price The price of the Food
     * @param energy The initial amount of energy the Food provides
     * @param cookable Whether the food may be cooked or not
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
    public Food(String name, double price, int energy, boolean cookable) {

        super(name, price);
        this.energy = energy;
        this.cookable = cookable;
        this.cooked = false;
        
    }

    /**
     * Constructs a new instance of Food.
     * @param name The name of the Food
     * @param price The price of the Food
     * @param energy The initial amount of energy the Food provides
     * @param cookable Whether the food may be cooked or not
     * @param cooked Whether the food is cooked or not. This parameter is optional, and is set to false by default.
     * This means you should never have to set this to false explicitly
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
    public Food(String name, double price, int energy, boolean cookable, boolean cooked) {

        super(name, price);
        this.energy = energy;
        this.cookable = cookable;
        this.cooked = cooked;
        
    }

}
