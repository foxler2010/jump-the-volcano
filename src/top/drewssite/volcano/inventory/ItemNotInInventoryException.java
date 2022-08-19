package top.drewssite.volcano.inventory;

import top.drewssite.volcano.items.Item;

/**
 * This exception is thrown when you try to add an item to an inventory, but the max umber of items has been reahed and no more can be added.
 * @author foxler2010
 * @since v1.0
 * @see Inventory
*/
public class ItemNotInInventoryException extends Exception {

    /**
     * Constructs a new ItemNotInInventoryException instance.
     * @author foxler2010
     * @since v1.0
     * @see Inventory
     */
    public ItemNotInInventoryException(Item item) {
        
        super("There are no " + item.getName() + "s in the inventory at this time.");

    }
    
}
