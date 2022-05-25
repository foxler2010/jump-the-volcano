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
    int size() {

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

    void add(Item item) throws InventoryFullException, InventoryItemLimitReachedException, InventorySublistFullException {

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
        if ((this.size() < this.maxTotalItems) || (this.maxTotalItems == -1)) {

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

}
