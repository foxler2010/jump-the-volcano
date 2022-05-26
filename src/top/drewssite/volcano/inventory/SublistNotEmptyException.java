package top.drewssite.volcano.inventory;

import top.drewssite.volcano.items.ItemType;

/**
 * This exception is thrown when you try to create a sublist in the player's inventory for a type that already has a sublist dedicated to it
 * @author foxler2010
 * @since v1.0
 * @see InventoryV3
 */
public class SublistNotEmptyException extends Exception {
    
    /**
     * Constructs a new SublistNotEmptyException instance. This shouldn't need to be called by mod developers because the exception is only used within the InventoryV3 class, and nowhere else.
     * @param type The type of item that is stored in the non-empty sublist.
     * @author foxler2010
     * @since v1.0
     * @see SublistNotEmptyException
     * @see InventoryV3
     */
    public SublistNotEmptyException(ItemType type) {

        super("The " + type + " sublist is not empty!");

    }

}
