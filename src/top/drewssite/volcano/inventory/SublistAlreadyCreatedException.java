package top.drewssite.volcano.inventory;

import top.drewssite.volcano.items.ItemType;

/**
 * This exception is thrown when you try to create a sublist in the player's inventory for a type that already has a sublist dedicated to it.
 * @author foxler2010
 * @since v1.0
 * @see Inventory
 */
public class SublistAlreadyCreatedException extends Exception {
    
    
    public SublistAlreadyCreatedException(ItemType type) {

        super(type + " already has a sublist dedicated to it!");

    }

}
