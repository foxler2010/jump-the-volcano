package top.drewssite.volcano.inventory;

import top.drewssite.volcano.items.Item;

/**
 * This exception is thrown when you try to add an item to an inventory, but the max number of that item has been reached and no more can be added.
 * @author foxler2010
 * @since v1.0
 * @see InventoryV3
*/
public class InventoryItemLimitReachedException extends Exception {

    private Item item;
    private int maxAmount;

    /**
     * Constructs a new InventoryItemLimitReachedException instance.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public InventoryItemLimitReachedException(Item item, int maxAmount) {
        
        super("You can only have " + maxAmount + " " + item.getName() + "s in this inventory at once.");
        
        this.item = item;
        this.maxAmount = maxAmount;

    }

    /** Returns the item that has reached its limit
     * @return The type of item that is full
     * @author foxler2010
     * @since v1.0
     * @see InventoryItemLimitReachedException
     */
    public Item getItem() {

        return item;

    }

    /** Returns the amount of items that have reached their limit
     * @return The amount of items that is reaching the limit for that item
     * @author foxler2010
     * @since v1.0
     * @see InventoryItemLimitReachedException
     */
    public int getAmountOfItems() {

        return maxAmount;

    }
    
}