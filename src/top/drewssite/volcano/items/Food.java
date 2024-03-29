package top.drewssite.volcano.items;

/**
 * This class implements the "Food" ItemType, allowing the player to eat things.
 * @author foxler2010
 * @since v1.0
 * @see Priceable
 * @see Item
 */
public class Food extends Priceable {

    // VARS
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
    public int getEnergy() {

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
     * Returns whether a food is cookable or not.
     * @return Whether a food is cookable or not.
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
    public boolean isCookable() {

        return cookable;

    }

    /**
     * Returns whether a food is cooked or not.
     * @return Whether a food is cooked or not.
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
    public boolean isCooked() {

        return cooked;

    }

    /**
     * Sets whether a food is cooked or not
     * @param cooked Whether a food is cookable or not.
     * @author foxler2010
     * @throws FoodUncookableException
     * @since v1.0
     * @see Food
     */
    public void cook() throws FoodUncookableException {

        if (cookable) {

            this.cooked = true;

        } else {

            throw new FoodUncookableException("The " + this.getName() + " food item is not cookable.");

        }

    }

    /**
     * Constructs a new instance of Food. The optional parameter "cooked" may be
     * specified if the food is pre-cooked.
     * @param name     The name of the Food
     * @param price    The price of the Food
     * @param energy   The initial amount of energy the Food provides
     * @param cookable Whether the food may be cooked or not
     * @author foxler2010
     * @since v1.0
     * @see Food
     */
    public Food(String name, double price, int energy, boolean cookable) {

        super(name, ItemType.FOOD, price, false);
        this.energy = energy;
        this.cookable = cookable;
        this.cooked = false;

    }

    /**
     * Constructs a new instance of Food. Cooked is set to false by default
     * @param name     The name of the Food
     * @param price    The price of the Food
     * @param energy   The initial amount of energy the Food provides
     * @param cookable Whether the food may be cooked or not
     * @param cooked   Whether the food is cooked or not. This parameter is optional, and is set to false by default. This means you should never have to set this to false explicitly.
     * @author foxler2010
     * @throws FoodUncookableException
     * @since v1.0
     * @see Food
     */
    public Food(String name, double price, int energy, boolean cookable, boolean cooked) throws FoodUncookableException {

        super(name, ItemType.FOOD, price, false);
        this.energy = energy;
        this.cookable = cookable;

        if (cookable) {

            this.cooked = cooked;

        } else {

            throw new FoodUncookableException("The " + name + " food item is not cookable.");

        }

    }

}
