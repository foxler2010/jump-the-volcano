package top.drewssite.volcano.items;

/**
 * This class provides the game with liquids,
 * which can be used to fill bottles, bathe in, soak/wash things in, and more!
 * @author foxler2010
 * @since v1.0
 * @see Food
 * @see Junk
 * @see Item
 */
public class Liquid extends Priceable {

    private int energy;

    /**
     * A liquid may not be bottled unless this is true.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    private boolean isBottleable;

    /**
     * This variable represents the amount of hydration a liquid provides when drunken.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    private int hydration;

    public int getEnergy() {
		return energy;
	}

    public void setEnergy(int energy) {
		this.energy = energy;
	}

    /**
     * Returns the bottleability of the liquid.
     * @return Whether the liquid is bottleable or not.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    public boolean getBottleability() {
        return isBottleable;
    }

    /**
     * Sets the bottleability of the liquid.
     * @param isBottleable Whether the liquid is bottleable or not.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    public void setBottleability(boolean isBottleable) {
        this.isBottleable = isBottleable;
    }

    /**
     * Returns the hydration of the liquid.
     * @return How much hydration the liquid provides when drunken.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    public int getHydration() {
        return hydration;
    }

    /**
     * Sets the hydration of the liquid.
     * @param hydration How much hydration the liquid provides when drunken.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    public void setHydration(int hydration) {
        this.hydration = hydration;
    }

    /**
     * Contructs a new Liquid instance.
     * @param name The name of the liquid.
     * @param price The price of the liquid.
     * @param energy The amount of energy the liquid provides.
     * @param hydration Howmuch hydration the liquid provides when drunken.
     * @param isBottleable Whether the liquid can be bottled or not.
     */
    public Liquid(String name, double price, int energy, int hydration, boolean isBottleable) {

        super(name, ItemType.LIQUID, price, false);

        this.energy = energy;

        this.isBottleable = isBottleable;

        this.hydration = hydration;

    }
    
}
