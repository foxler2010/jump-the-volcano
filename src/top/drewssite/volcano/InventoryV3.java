package top.drewssite.volcano;

import java.util.ArrayList;

/** The third iteration
 * @author foxler2010
 * @since v1.0
 * @see Player
 */
class InventoryV3 {
    
    //sublists are stored here
    private ArrayList<ArrayList<Item>> inventory;
    //index of sublists based on item type
    private ArrayList<ItemType> types;
    //max amount of items that can be stored in the inventory. -1 is infinite
    private final int maxTotalItems;
    
    //lists that can be used to set a max of a specific type or specific item
    private final ArrayList<Item> maxItemsID;
    private final ArrayList<Integer> maxItemsAmount;
    
    private final ArrayList<ItemType> maxItemsOfTypeID;
    private final ArrayList<Integer> maxItemsOfTypeAmount;

    /**
     * Creates a new InventoryV3
     * @param maxItems The max number of items that can be stored in the inventory
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    InventoryV3(int maxTotalItems, ArrayList<Item> maxItemsID, ArrayList<Integer> maxItemsAmount, ArrayList<ItemType> maxItemsOfTypeID, ArrayList<Integer> maxItemsOfTypeAmount) {

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
    void createSublist(ItemType type) throws SublistAlreadyCreatedException {

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
    void deleteSublist(ItemType type, boolean clearList) throws SublistNotEmptyException {

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
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    int amountOf(Item item) {

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
     */
    int amountOf(ItemType type) {

        return inventory.get(types.indexOf(type)).size();

    }

    /** This method returns the amount of items present in the inventory
     * @return The amount of items present in the inventory
     * @author foxler2010
     * @since v1.0
     * @see InventoryV3
     */
    int totalItems() {

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

    void addItem(Item item) throws InventoryFullException, InventoryItemLimitReachedException, InventorySublistFullException {

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
        if ((this.totalItems() < this.maxTotalItems) || (this.maxTotalItems == -1)) {

            if ((this.amountOf(item.getType()) < this.maxItemsOfTypeAmount.get(this.maxItemsOfTypeID.indexOf(item.getType()))) || !maxItemsOfTypeLimit) {

                if ((this.amountOf(item) < this.maxItemsAmount.get(maxItemsID.indexOf(item))) || !maxItemsLimit) {
                    
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

    void removeItem(Item item) throws ItemNotInInventoryException {

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
    String fancyToString() {

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

}
