package top.drewssite.volcano;

/**
 * This exception is thrown when you try to add an item to an inventory, but the max umber of items has been reahed and no more can be added.
 * @author foxler2010
 * @since v1.0
 * @see InventoryV3
*/
public class InventoryItemLimitReachedException extends Exception {

    /**
     * Constructs a new InventoryItemLimitReachedException instance.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public InventoryItemLimitReachedException(Item item, int maxAmount) {
        
        super("You can only have " + maxAmount + " " + item.getName() + "s in this inventory at once.");

    }
    
}
