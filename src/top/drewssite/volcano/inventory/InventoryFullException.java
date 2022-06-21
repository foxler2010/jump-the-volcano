package top.drewssite.volcano.inventory;

/**
 * This exception is thrown when you try to add an item to an inventory, but the max number of items has been reached and no more can be added.
 * @author foxler2010
 * @since v1.0
 * @see InventoryV3
*/
public class InventoryFullException extends Exception {

    /**
     * Constructs a new InventoryFullException instance.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public InventoryFullException() {
        
        super("The inventory has reached the max amount of items and can no longer recieve any more items.");

    }
    
}
