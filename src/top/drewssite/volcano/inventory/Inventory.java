package top.drewssite.volcano.inventory;
import java.util.ArrayList;

import top.drewssite.volcano.items.Item;
import top.drewssite.volcano.items.ItemType;
import top.drewssite.volcano.items.Player;

//if you're wondering about why InventoryV3 is the third iteration, it is because this is the second;
//the first version was just a regular ArrayList<Item>.

/**
 * Unlike a traditional ArrayList, this one sorts everything into sub-lists.
 * The class is more of a wrapper than an object, as it only contains 1 internal variable,
 * but it does all the sorting and things automatically, pretty much pretending to be a regular list.
 * @author foxler2010
 * @since v1.0
 * @see Player
 */
public class Inventory {
    
    //list of lists
    private ArrayList<ArrayList<Item>> inventory;

    /**
     * The constructor for the Inventory class.
     * Initializes an ArrayList<ArrayList<Item>> and fills it with 7 sublists corresponding to the 7 itemTypes.
     * @author foxler2010
     * @see Inventory
     * @since v1.0
     */
    public Inventory() {
        //initialize big list
        inventory = new ArrayList<ArrayList<Item>>();
        //initialize the sub-lists inside of big list
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
    }

    /**
     * Add an item to the inventory. It will be automaticaly sorted into a siblist based on its type.
     * @param item The item to add to the inventory
     * @author foxler2010
     * @since v1.0
     * @see Inventory
     */
    void addItem(Item item) {
        
        //use different lists based on type
        switch (item.getType()) {
            case JUNK:
            inventory.get(0).add(item);
            break;
            case FOOD:
            inventory.get(1).add(item);
            break;
            case WEAPON:
            inventory.get(2).add(item);
            break;
            case PET:
            inventory.get(3).add(item);
            break;
            case KIT:
            inventory.get(4).add(item);
            break;
            case MONSTER:
            inventory.get(5).add(item);
            break;
        }
    }

    /**
     * Return the item atthe specified type enum and sublist index.
     * @param type an itemType enum detailing the type of the item to be removed.
     * @param index The index of the item to be removed
     * @return The item at the specified index in the sublist corresponding to the given type.
     * @author foxler2010
     * @see Inventory
     * @since v1.0
     */
    Item getItem(ItemType type, int index) {
        
        //initialize as null, because it will throw an error if I don't
        Item requestedItem = null;

        //use different lists based on type
        switch (type) {
            case JUNK:
            return requestedItem = inventory.get(0).get(index);
            case FOOD:
            return requestedItem = inventory.get(1).get(index);
            case WEAPON:
            return requestedItem = inventory.get(2).get(index);
            case PET:
            return requestedItem = inventory.get(3).get(index);
            case KIT:
            return requestedItem = inventory.get(4).get(index);
            case MONSTER:
            return requestedItem = inventory.get(5).get(index);
            //because it thinks there are more enum states
            default:
            return requestedItem;
        }
    }

    /**
     * Remove an item from the inventory based on the item's itemType enum and its index in the sublist
     * @param type
     * @param index
     * @author foxler2010
     * @since v1.00
     * @see Inventory
     */
    void removeItem(ItemType type, int index) {
        
        //use different lists based on type
        switch (type) {
            case JUNK:
            inventory.get(0).remove(index);
            break;
            case FOOD:
            inventory.get(1).remove(index);
            break;
            case WEAPON:
            inventory.get(2).remove(index);
            break;
            case PET:
            inventory.get(3).remove(index);
            break;
            case KIT:
            inventory.get(4).remove(index);
            break;
            case MONSTER:
            inventory.get(5).remove(index);
            break;
        }
    }

    /**
     * Remove an item from the inventory based of of the sublist index and the item index.
     * @param typeIndex
     * @param index
     * @author foxler2010
     * @since v1.0
     * @see Inventory
     */
    void removeItem(int typeIndex, int index) {
        
        //use different lists based on type
        switch (typeIndex) {
            case 0:
            inventory.get(0).remove(index);
            break;
            case 1:
            inventory.get(1).remove(index);
            break;
            case 2:
            inventory.get(2).remove(index);
            break;
            case 3:
            inventory.get(3).remove(index);
            break;
            case 4:
            inventory.get(4).remove(index);
            break;
            case 5:
            inventory.get(5).remove(index);
            break;
        }
    }

    /**
     * Removes an item from the inventory based on item name.
     * If multiple of the same instance are present, only one will be removed.
     * @author foxler2010
     * @param item The item to be removed
     * @since v1.0
     * @see Inventory
     */
    void removeItem(Item item) {
        
        //use different lists based on type
        switch (item.getType()) {
            case JUNK:
            inventory.get(0).remove(item);
            break;
            case FOOD:
            inventory.get(1).remove(item);
            break;
            case WEAPON:
            inventory.get(2).remove(item);
            break;
            case PET:
            inventory.get(3).remove(item);
            break;
            case KIT:
            inventory.get(4).remove(item);
            break;
            case MONSTER:
            inventory.get(5).remove(item);
            break;
        }
    }

    /**
     * Returns true if an item is present in the inventory, false if the item is not present.
     * @author foxler2010
     * @since v1.0
     * @return Boolean detailing whether an item is in the inventory or not.
     * @see Inventory
     * @param item The item to check for.
     */
    boolean checkForItem(Item item) {

        //initialize as false, because it will throw an error if I don't
        boolean itemIsPresent = false;

        //for every sub-list, check for the item.
        //if true, return the result immediately so that the boolean won't get messed with by the other if statements.
        for (int i = 0; i <=5; i++) {
            if (inventory.get(0).contains(item)) {
                itemIsPresent = true;
                return itemIsPresent;
            } else {
                itemIsPresent = false;
            }
        }

        return itemIsPresent;
    }

    /**
     * Find the index of an item. The index is relative to the sub-list the item is inside of.
     * The type does not have to be given, because the method just looks at the attributes of the item to find it.
     * Returns -1 if the item is nonexistent.
     * @author foxler2010
     * @see Inventory
     * @since v1.0
     * @param item The item to find the index of.
     * @return The index of the given item.
     */
    int indexOfItem(Item item) {

        //use different lists based on type
        switch (item.getType()) {
            case JUNK:
            return inventory.get(0).indexOf(item);
            case FOOD:
            return inventory.get(1).indexOf(item);
            case WEAPON:
            return inventory.get(2).indexOf(item);
            case PET:
            return inventory.get(3).indexOf(item);
            case KIT:
            return inventory.get(4).indexOf(item);
            case MONSTER:
            return inventory.get(5).indexOf(item);
            //because it thinks there are more enum states
            default:
            return -1;
        }
    }

    //The below method needs to be public because it is inherited from the public toString() method in java.lang.Object.
    /**
     * Return a String containing a comma separated list of all the items in the inventory, using the items' fancy names.
     * The output of this method is the same format as the old inventory system, and if you have a lot of items, the list can be very long.
     * It is reccomended to use fancyToString() instead of this method.
     * @author foxler2010
     * @see Inventory
     * @since v1.0
     * @return A list of everything in the inventory.
     */
    public String toString() {
        
        //initialize the finalString variable
        String finalString = "";

        //STRUCTURE:
        //loop thru the sub-lists {
            //loop thru each item {
                //add item to finalString
            //}
        //}

        for (int i = 0; i < 5; i++) {

            //each iteration is a different sub-list

            for (int j = 0; j < inventory.get(i).size(); j++) {
                
                //each iteration is a different item

                //fetch the item we are working with, and add its "fancy name" to finalString
                finalString = finalString + inventory.get(i).get(j).getName();

                //add a comma and space, so the next item isn't "hugging" the first
                finalString = finalString + ", ";

            }

        }

        //remove comma + space at the end
        //this singular line took about ~1 month of effort to get right
        finalString = finalString.substring(0, finalString.length() - 2);

        return finalString;

    }

    /**
     * Return a String containing a comma separated list of all the items in the inventory, using the items' fancy names.
     * Multiple items of the same instance are grouped so that they show like this: "Old Can Of Beans x10".
     * This is the method currently used to display the inventory every turn.
     * @author foxler2010
     * @see Inventory
     * @since v1.0
     * @return A list of everything in the inventory, with items of the same instance grouped together.
     */
    String fancyToString() {

        //initialize the finalString variable
        String finalString = "";

        //loop thru sub-lists
        for (int i = 0; i < inventory.size(); i++) {

            //initialize alreadyCounted variable
            ArrayList<Item> alreadyCounted = new ArrayList<Item>();

            //loop thru items in sub-lists
            for (int j = 0; j < inventory.get(i).size(); j++) {

                //only run the code if the item could not be found in this list
                if (alreadyCounted.indexOf(inventory.get(i).get(j)) == -1) {
                    
                    //initialize the amountOfItem variable
                    int amountOfItem = 0;

                    //count how many instances of the item are in the sub-list
                    //this includes the one we are looping through
                    for (int k = 0; k < inventory.get(i).size(); k++) {

                        //check if the item with index k is the same as the item we are counting
                        if (inventory.get(i).get(k) == inventory.get(i).get(j)) {
                            amountOfItem++;
                        }

                    }

                    //compile the info we've gathered into a string and add it to finalString
                    //if amountOfItem = 1, exclude the "x1" that would normally be included.
                    if (amountOfItem == 1) {
                        finalString = finalString + inventory.get(i).get(j).getName() + ", ";
                    } else {
                        finalString = finalString + inventory.get(i).get(j).getName() + " x" + amountOfItem + ", ";
                    }
                
                    //add the item to the alreadyCounted list, to make sure we don't count the item again
                    alreadyCounted.add(inventory.get(i).get(j));

                }
                
            }
                
        }

        //remove the comma + space at the end of finalString (since there is no item after it; correct grammar y'know)
        //this singular line took about ~1 month of effort to get right
        //copied from above non-fancy method
        finalString = finalString.substring(0, finalString.length() - 2);

        //return final result
        return finalString;
        
    }

    /**
     * Returns the amount of items in the inventory.
     * Not to be confused with sizeOfSubList(), which returns the amount of items in a given sublist.
     * @author foxler2010
     * @see Inventory
     * @return The amount of items in the inventory.
     * @since v1.0
     */
    int sizeOfInventory() {
        int size = inventory.get(0).size();
        for (int i = 1; i < 5; i++) {
            size = size + inventory.get(i).size();
        }
        return size;
    }

    /**
     * Returns the amount of items in a given sublist. Not to be confused with sizeOfInventory().
     * @author foxler2010
     * @param subListIndex The index of the sublist you want the size of.
     * @return The size of the sublist with the index 'subListIndex'.
     * @since v1.0
     * @see Inventory
     */
    int sizeOfSubList(int subListIndex) {
        return inventory.get(subListIndex).size();
    }

}
