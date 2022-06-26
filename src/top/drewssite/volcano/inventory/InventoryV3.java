package top.drewssite.volcano.inventory;

import java.util.ArrayList;

import top.drewssite.volcano.data.Data;
import top.drewssite.volcano.items.Item;
import top.drewssite.volcano.items.ItemType;

/** The third iteration
 * @author foxler2010
 * @since v1.0
 * @see Player
 */
public class InventoryV3 {
    
    /** List that stores lists of items. Each sublist stores a different type of item.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    private ArrayList<ArrayList<Item>> inventory;

    /** This list stores ItemTypes and the indexes of the types in the list are the indexes of those types' sublists in the inventory list. Used internally to manage sublists.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    private ArrayList<ItemType> types;

    /**
     * Max amount of items that can be stored in the inventory. -1 is infinite.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    private final int maxTotalItems;
    
    //lists that can be used to set a max of a specific type or specific item
    private final ArrayList<Item> maxItemsID;
    private final ArrayList<Integer> maxItemsAmount;
    
    private final ArrayList<ItemType> maxItemsOfTypeID;
    private final ArrayList<Integer> maxItemsOfTypeAmount;

    /**
     * Creates a new InventoryV3.
     * @param maxTotalItems The max amount of items that can be stored in the inventory. -1 is infinite.
     * @param maxItemsID A list of items with maximum storage limits
     * @param maxItemsAmount A list corresponding to maxItemsID which contains the amounts of each item allowed in the inventory.
     * If the item "oldCanOfBeans" was at index 0 in maxItemsID then the number at index 0 in maxItemsAmount would be the maximum amount of
     * oldCanOfBeans items allowed in the inventory.
     * @param maxItemsOfTypeID This list and the corresponding integer list mirror that of maxItemsID and maxItemsAmount. The only difference is that
     * maxItemsOfTypeID and maxItemsOfTypeAmount control the max amount of a type of item instead of a specific item.
     * @param maxItemsOfTypeAmount This list corresponds to maxItemsOfTypeID, providing the maximum amounts of items for certain types.<br><br>
     * <b>An important note</b> for all maxItems lists is that if the item or type in the ID list is null/does not exist, then the value at the same index in
     * the Amount list does not do anything. Be sure that your items and types match up when creating these lists, or the limits may be incorrect/not set
     * @author foxler2010
     * @throws InventorySublistFullException
     * @throws InventoryItemLimitReachedException
     * @throws InventoryFullException
     * @since v1.0
     * @see InventoryV3
     */
    public InventoryV3(int maxTotalItems, ArrayList<Item> maxItemsID, ArrayList<Integer> maxItemsAmount, ArrayList<ItemType> maxItemsOfTypeID, ArrayList<Integer> maxItemsOfTypeAmount) {

        inventory = new ArrayList<ArrayList<Item>>();
        types = new ArrayList<ItemType>();

        this.maxTotalItems = maxTotalItems;

        this.maxItemsID = maxItemsID;
        this.maxItemsAmount = maxItemsAmount;

        this.maxItemsOfTypeID = maxItemsOfTypeID;
        this.maxItemsOfTypeAmount = maxItemsOfTypeAmount;

    }
    
    /** Creates a new sublist. Does not allow creation if there is already a sublist created for the type specified.
     * @param type
     * @throws SublistAlreadyCreatedException
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     * @see SublistAlreadyCreatedException
     */
    private void createSublist(ItemType type) throws SublistAlreadyCreatedException {

        for (int i = 0; i < types.size(); i++) {

            if (type == types.get(i)) {

                throw new SublistAlreadyCreatedException(type);

            }

        }

        inventory.add(new ArrayList<Item>());
        types.add(type);

    }

    
    /** Remove a sublist from the inventory.
     * The method has two modes: "clear", and "keep". "clear" mode deletes all items in the sublist when it is removed.
     * "keep" mode will preserve the items and instead throw an exception if the sublist is not empty.
     * This is useful if you want to only delete empty sublists, or just don't want to get rid of items.
     * @param type The type of item in the sublist you want to remove
     * @param clearList Whether you want to clear the sublist or throw an exception if it the list is not empty. 
     * @author foxler2010
     * @throws SublistNotEmptyException
     * @since v1.0
     * @see InventoryV3
     */
    //delete sublist
    private void deleteSublist(ItemType type, boolean clearList) throws SublistNotEmptyException {

        boolean sublistDeleted = false;

        try {
            
            //see if we can grab something from index 0
            inventory.get(types.indexOf(type)).get(0);
            //if this succeeds and clearList is false, the exception will be thrown
        
        } catch (IndexOutOfBoundsException e) { //if we can't the list is empty and we are clear to delete it

            inventory.remove(types.indexOf(type));
            types.remove(types.indexOf(type));
            //let everyone know we deleted the list, so the exception isn't thrown
            sublistDeleted = true;
            
        }

        if (clearList) { //if the list was not empty, but we still want to delete it, then this is where it happens

            inventory.remove(types.indexOf(type));
            types.remove(types.indexOf(type));
            //let everyone know we deleted the list, so the exception isn't thrown
            sublistDeleted = true;

        }

        //if the list was not deleted, it must've still had items in it.
        //throw an exception since the list wasn't deleted
        if (!sublistDeleted) {
            
            throw new SublistNotEmptyException(type);

        }

    }

    /** Returns the number of a specified item in the inventory
     * @param item The item to count
     * @return The amount of a specific item in the inventory
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public int amountOf(Item item) {

        int amountOfItem = 0;

        for (int i = 0; i < inventory.get(types.indexOf(item.getType())).size(); i++) { //loop thru the list with the item in it

            if (inventory.get(types.indexOf(item.getType())).get(i) == item) { //if the current item matches the one we are counting

                amountOfItem++; //count it

            }

        }

        return amountOfItem; //return final result

    }

    /** Returns the amount of items of the specified type contained within the inventory
     * @param type The type of item to return the amount of
     * @return The amount of items of a certain type contained in the inventory.
     * @author foxler2010
     * @since 1.0
     * @see InventoryV3
     */
    public int amountOf(ItemType type) {

        if (types.indexOf(type) == -1) {

            return 0;

        }

        return inventory.get(types.indexOf(type)).size();

    }

    /** Returns the number of different types of items that are stored within the inventory
     * @return The amount of different types of items stored within the inventory
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public int amountOfTypes() {

        return inventory.size();

    }

    /** This method returns the amount of items present in the inventory
     * @return The amount of items present in the inventory
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public int totalItems() {

        int size = 0; 

        //loop thru sublists
        for (int i = 0; i < inventory.size(); i++) {

            //loop thru each sublist
            for (int j = 0; j < inventory.get(i).size(); j++) {

                //count every item
                size++;

            }

        }

        //return resulting number
        return size;

    }

    
    /** Add an item to the inventory
     * @param item The item to add
     * @throws InventoryFullException
     * @throws InventoryItemLimitReachedException
     * @throws InventorySublistFullException
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public void addItem(Item item) throws InventoryFullException, InventoryItemLimitReachedException, InventorySublistFullException {

        //step 1, set some variables
        boolean maxItemsLimit = true;
        boolean maxItemsOfTypeLimit = true;

        //see if the item is in the lists of items with maximums
        try {

            this.maxItemsAmount.get(this.maxItemsID.indexOf(item));

        } catch (IndexOutOfBoundsException e) { //if its set the local boolean false

            maxItemsLimit = false;

        }
        
        //same thing but with types
        try {

            this.maxItemsOfTypeAmount.get(this.maxItemsOfTypeID.indexOf(item.getType())); //use item.getType() instead of just item.

        } catch (IndexOutOfBoundsException e) {

            maxItemsOfTypeLimit = false;

        }

        //step 2, check if the the item can be added to the inventory
        if ((this.totalItems() < this.maxTotalItems) || (this.maxTotalItems == -1)) { //check if it fits into the whole inventory

            //best-case
            if (!maxItemsOfTypeLimit) {

                //best-case
                if (!maxItemsLimit) {

                    //step 3, add the item to the inventory

                    try { //if sublist already exists
                        
                        this.inventory.get(this.types.indexOf(item.getType())).add(item);

                    } catch (IndexOutOfBoundsException e) { //if we can't find it

                        try {

                            this.createSublist(item.getType()); //create new one
                            this.inventory.get(this.types.indexOf(item.getType())).add(item); //then add

                        } catch (SublistAlreadyCreatedException f) { //this code will never get called but we need it anyway

                            f.printStackTrace();

                        }

                    }

                } else if ((this.amountOf(item) < this.maxItemsAmount.get(maxItemsID.indexOf(item)))) {
                    
                    //step 3, add the item to the inventory

                    try { //if sublist already exists
                        
                        this.inventory.get(this.types.indexOf(item.getType())).add(item);

                    } catch (IndexOutOfBoundsException e) { //if we can't find it

                        try {

                            this.createSublist(item.getType()); //create new one
                            this.inventory.get(this.types.indexOf(item.getType())).add(item); //then add

                        } catch (SublistAlreadyCreatedException f) { //this code will never get called but we need it anyway

                            f.printStackTrace();

                        }

                    }
    
                } else { //step 3, throw exception

                    throw new InventoryItemLimitReachedException(item, this.maxItemsAmount.get(this.maxItemsID.indexOf(item)));

                }

            } else if ((this.amountOf(item.getType()) < this.maxItemsOfTypeAmount.get(this.maxItemsOfTypeID.indexOf(item.getType())))) {

                if (!maxItemsLimit) {

                    //step 3, add the item to the inventory

                    try { //if sublist already exists
                        
                        this.inventory.get(this.types.indexOf(item.getType())).add(item);

                    } catch (IndexOutOfBoundsException e) { //if we can't find it

                        try {

                            this.createSublist(item.getType()); //create new one
                            this.inventory.get(this.types.indexOf(item.getType())).add(item); //then add

                        } catch (SublistAlreadyCreatedException f) { //this code will never get called but we need it anyway

                            f.printStackTrace();

                        }

                    }
                    
                } else if ((this.amountOf(item) < this.maxItemsAmount.get(maxItemsID.indexOf(item)))) {
                    
                    //step 3, add the item to the inventory

                    try { //if sublist already exists
                        
                        this.inventory.get(this.types.indexOf(item.getType())).add(item);

                    } catch (IndexOutOfBoundsException e) { //if we can't find it

                        try {

                            this.createSublist(item.getType()); //create new one
                            this.inventory.get(this.types.indexOf(item.getType())).add(item); //then add

                        } catch (SublistAlreadyCreatedException f) { //this code will never get called but we need it anyway

                            f.printStackTrace();

                        }

                    }
    
                } else { //step 3, throw exception

                    throw new InventoryItemLimitReachedException(item, this.maxItemsAmount.get(this.maxItemsID.indexOf(item)));

                }

            } else { //step 3, throw exception

                throw new InventorySublistFullException(item.getType(), this.maxItemsOfTypeAmount.get(this.maxItemsOfTypeID.indexOf(item.getType())));

            }

        } else { //step 3, throw exception

            throw new InventoryFullException();

        }

    }
    //i realize now how bad the original version of .addItem() was; it was very hard to revise it so it works, and I am still questioning whether it was worth it to make InventoryV3 so configurable,
    //but I continue to believe that it has helped me a lot with making more complicated code, so I think it was worth it. But still, so, so hard to pull off.
    
    /** Removes an item from the inventory
     * @param item The item to remove
     * @throws ItemNotInInventoryException
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public void removeItem(Item item) throws ItemNotInInventoryException {

        try {

            inventory.get(types.indexOf(item.getType())).remove(item);

        } catch (IndexOutOfBoundsException e) { //if the item is not in the inventory

            throw new ItemNotInInventoryException(item);

        }

        //check to see if the sublist has any items in it
        if (this.amountOf(item.getType()) == 0) {

            try {

                this.deleteSublist(item.getType(), false); //delete it if there are no items

            } catch (SublistNotEmptyException e) { //never going to happen

                e.printStackTrace();

            }

        }

    }

    /** Changes the name of an Item to something else. The Item has to be in the inventory, otherwise it wouldn't exist.
     * This will probably be changed in the future.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public void renameItem(Item item, String newName) throws ItemNotInInventoryException {

        Data.player.getInventory().removeItem(item);

        item.setName(newName);

        try {Data.player.getInventory().addItem(item);} catch (InventoryFullException e) {} catch (InventorySublistFullException e) {} catch (InventoryItemLimitReachedException e) {} //the errors will never happen, we just removed it so it will be able to be replaced.

    }

    /** Return a list of all the items of a certain type
     * @param type The type to return a list of items of.
     * @return A list of all items of the specified type. Returns an empty list if there are no items of the specified type.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public ArrayList<Item> getAllItemsOfType(ItemType type) {

        if (types.indexOf(type) == -1) {

            return new ArrayList<Item>();

        }

        return inventory.get(types.indexOf(type));

    }

    /** Outputs every item in the inventory together in one ArrayList<Item>.
     * @return An ArrayList<Item> containing every item in the player's inventory
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public ArrayList<Item> toArrayList() {

        ArrayList<Item> list = new ArrayList<Item>();

        for (int i = 0; i < inventory.size(); i++) {

            for (int j = 0; j < inventory.get(i).size(); i++) {

                list.add(inventory.get(i).get(j));

            }

        }

        return list;

    }

    /** Checks to see whether an item exists within the inventory
     * @param item the item to check for
     * @return whether the item is present in the inventory or not
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public boolean checkForItem(Item item) {

            if (inventory.get(types.indexOf(item.getType())).contains(item)) { //check if the item's sublist contains the item

                return true; //if it does return true; break

            }

            return false; //if it doesn't the false is returned

    }

    //Copied from Inventory class
    /**
     * Return a String containing a comma separated list of all the items in the inventory, using the items' fancy names.
     * The output of this method is the same format as the old inventory system, and if you have a lot of items, the list can be very long.
     * It is reccomended to use fancyToString() instead of this method.
     * @author foxler2010
     * @see InventoryV3
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

        for (int i = 0; i < this.inventory.size(); i++) {

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

    //Also copied from Inventory class, but more heavily modified
    /**
     * Return a String containing a comma separated list of all the items in the inventory, using the items' fancy names.
     * Multiple items of the same instance are grouped so that they show like this: "Old Can Of Beans x10".
     * This is the method currently used to display the inventory every turn.
     * @author foxler2010
     * @see InventoryV3
     * @since v1.0
     * @return A list of everything in the inventory, with items of the same instance grouped together.
     */
    public String fancyToString() {

        //initialize the finalString variable
        String finalString = "";

        //loop thru sub-lists
        for (int i = 0; i < this.inventory.size(); i++) {

            //initialize alreadyCounted variable
            ArrayList<Item> alreadyCounted = new ArrayList<Item>();

            //loop thru items in sub-lists
            for (int j = 0; j < this.inventory.get(i).size(); j++) {

                //only run the code if the item could not be found in this list
                if (alreadyCounted.indexOf(this.inventory.get(i).get(j)) == -1) {
                    
                    //initialize the amountOfItem variable
                    int amountOfItem = 0;

                    //count how many instances of the item are in the sub-list
                    //this includes the one we are looping through
                    for (int k = 0; k < this.inventory.get(i).size(); k++) {

                        //check if the item with index k is the same as the item we are counting
                        if (this.inventory.get(i).get(k) == this.inventory.get(i).get(j)) {
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

    /** Clears the inventory of all items. Used when the player dies and chooses to ressurect themselvves.
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    public void clear() {

        for (int i = 0; i < types.size(); i++) {

            try {

                this.deleteSublist(types.get(i), true);

            } catch (SublistNotEmptyException e) {

                //this will never happen

            }

        }

    }

}
