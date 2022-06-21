package top.drewssite.volcano.inventory;

import top.drewssite.volcano.items.ItemType;

/**
 * This exception is thrown when you try to add an item to an inventory, but the max number of items for that type has been reached and no more can be added.
 * @author foxler2010
 * @since v1.0
 * @see InventoryV3
*/
public class InventorySublistFullException extends Exception {

    private ItemType type;
    private int maxAmount;

    /**
     * Constructs a new InventorySublistFullException instance.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public InventorySublistFullException(ItemType type, int maxAmount) {
        
        super("You can only have " + maxAmount + " items of the " + type + " type in this inventory at once.");
        
        this.type = type;
        this.maxAmount = maxAmount;

    }

    /** Returns the type of item that is full
     * @return The type of item that is full
     * @author foxler2010
     * @since v1.0
     * @see InventorySublistException
     */
    public ItemType getFullType() {

        return type;

    }

    /** Returns the amount of items filling the type completely.
     * @return The amount of items filling the type completely
     * @author foxler2010
     * @since v1.0
     * @see InventorySublistException
     */
    public int getAmountOfItems() {

        return maxAmount;

    }
    
}
