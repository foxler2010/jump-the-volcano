package top.drewssite.volcano.items;

import top.drewssite.volcano.data.Data;
import top.drewssite.volcano.inventory.Inventory;

/**
 *	It's YOU!
 *	This class is special as technically it is an "Item", yet it can hold other Items,
 *	it has a level, money, and among other things you can control it directly.
 *	The class is mainly used to store the player's attributes while giving it Animal properties like the ability to attack
 *	@author foxler2010
 *	@see Animal
 *	@see Item
 *	@since	v1.0
 */
public class Player extends Animal {
	
	/**
	 * The experience level of the player. Can be used for a variety of things.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	private int level;

	/**
	 * The amount of money the player has. Used to buy and sell things in the various shops.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	private double money;

	/**
	 * The Inventory object storing all the items in the player's possesion
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	private Inventory inventory = new Inventory();

	/**
	 * Number of times the player has chosen the Jump the Volcano option
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfVolcanoVisits = 0;

	/**
	 * Number of times the player has chosen the Dumpster Dive option
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfDumpsterVisits = 0;

	/**
	 * Number of times the player has chosen the Shop option
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfShopVisits = 0;

	/**
	 * Number of times the player has chosen the Pet Store option
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfPetStoreVisits = 0;

	/**
	 * Number of times the player has chosen the Arena option
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfArenaVisits = 0;

	/**
	 * Number of times the player has chosen the Eat Food option
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfFoodsEaten = 0;
	
	/**
	 * Number of times the player has quit the game. This stat is not displayed if the value is zero.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	private int numOfQuittings = 0;

	/**
	 * The constructor for the Player class
	 * @author foxler2010
	 * @see Player
	 * @since v1.0
	 * @param name	The "fancy" name of the Player object. Doesn't do anything currently.
	 * @param strength	The strength of the player in combat. Does not currently do anything.
	 * @param level	The initial experience level of the player. In a regular game this is 0.
	 * @param money	The inital amount of money the player has. This is 0 in a regular game.
	 * @param startingInventory	This is what the player's inventory will contain when they start the game.
	 */
	public Player(String name, int strength, int level, double money, Inventory startingInventory) {
		super(name, ItemType.PLAYER, strength, false);
		this.level = level;
		this.money = money;
		this.inventory = startingInventory;
	}
	
	//GETTERS AND SETTERS
	
	/**
	 * The getter for the level variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * The getter for the money variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public double getMoney() {
	return money;
	}
	
	/**
	 * The setter for the level variable.
	 * @author foxler2010
	 * @param level The new value of the level variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * The setter for the money variable.
	 * @author foxler2010
	 * @param money The new value of the money variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * Sets the player's level to the current value + levelsToAdd
	 * @param levelsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void levelUp(int levelsToAdd) {

		Data.player.setLevel(Data.player.getLevel() + levelsToAdd);

	}

	/**
	 * Sets the player's balance to the current value + dollarsToAdd
	 * @param dollarsToAdd The amount of money to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void moneyUp(int dollarsToAdd) {

		Data.player.setLevel(Data.player.getLevel() + dollarsToAdd);

	}

	/**
	 * The getter for the numOfVolcanoVisits variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfVolcanoVisits() {
		return numOfVolcanoVisits;
	}

	/**
	 * The setter for the numOfVolcanoVisits variable.
	 * @author foxler2010
	 * @param numOfVolcanoVisits The new value of the numOfVolcanoVisits variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfVolcanoVisits(int numOfVolcanoVisits) {
		this.numOfVolcanoVisits = numOfVolcanoVisits;
	}

	/**
	 * Sets the numOfVolcanoVisits variable to the current value + visitsToAdd
	 * @param visitsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void volcanoVisitsUp(int visitsToAdd) {

		Data.player.setNumOfVolcanoVisits(Data.player.getNumOfVolcanoVisits() + visitsToAdd);

	}

	/**
	 * The getter for the numOfDumpsterVisits variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfDumpsterVisits() {
		return numOfDumpsterVisits;
	}

	/**
	 * The setter for the numOfDumpsterVisits variable.
	 * @author foxler2010
	 * @param numOfDumpsterVisits The new value of the numOfDumpsterVisits variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfDumpsterVisits(int numOfDumpsterVisits) {
		this.numOfDumpsterVisits = numOfDumpsterVisits;
	}

	/**
	 * Sets the numOfDumpsterVisits variable to the current value + visitsToAdd
	 * @param visitsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void dumpsterVisitsUp(int visitsToAdd) {

		Data.player.setNumOfDumpsterVisits(Data.player.getNumOfDumpsterVisits() + visitsToAdd);

	}

	/**
	 * The getter for the numOfShopVisits variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfShopVisits() {
		return numOfShopVisits;
	}

	/**
	 * The setter for the numOfShopVisits variable.
	 * @author foxler2010
	 * @param numOfShopVisits The new value of the numOfShopVisits variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfShopVisits(int numOfShopVisits) {
		this.numOfShopVisits = numOfShopVisits;
	}

	/**
	 * Sets the numOfShopVisits variable to the current value + visitsToAdd
	 * @param visitsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void shopVisitsUp(int visitsToAdd) {

		Data.player.setNumOfShopVisits(Data.player.getNumOfShopVisits() + visitsToAdd);

	}

	/**
	 * The getter for the numOfPetStoreVisits variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfPetStoreVisits() {
		return numOfPetStoreVisits;
	}

	/**
	 * The setter for the numOfPetStoreVisits variable.
	 * @author foxler2010
	 * @param numOfPetStoreVisits The new value of the numOfPetStoreVisits variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfPetStoreVisits(int numOfPetStoreVisits) {
		this.numOfPetStoreVisits = numOfPetStoreVisits;
	}

	/**
	 * Sets the numOfPetStoreVisits variable to the current value + visitsToAdd
	 * @param visitsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void petStoreVisitsUp(int visitsToAdd) {

		Data.player.setNumOfPetStoreVisits(Data.player.getNumOfPetStoreVisits() + visitsToAdd);

	}

	/**
	 * The getter for the numOfArenavisits variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfArenaVisits() {
		return numOfArenaVisits;
	}	

	/**
	 * The setter for the numOfArenaVisits variable.
	 * @author foxler2010
	 * @param numOfArenaVisits The new value of the numOfArenaVisits variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfArenaVisits(int numOfArenaVisits) {
		this.numOfArenaVisits = numOfArenaVisits;
	}

	/**
	 * Sets the numOfArenaVisits variable to the current value + visitsToAdd
	 * @param visitsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void arenaVisitsUp(int visitsToAdd) {

		Data.player.setNumOfArenaVisits(Data.player.getNumOfArenaVisits() + visitsToAdd);

	}

	/**
	 * The getter for the numOfFoodsEaten variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfFoodsEaten() {
		return numOfFoodsEaten;
	}

	/**
	 * The setter for the numOfFoodsEaten variable.
	 * @author foxler2010
	 * @param numOfFoodsEaten The new value of the numOfFoodsEaten variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfFoodsEaten(int numOfFoodsEaten) {
		this.numOfFoodsEaten = numOfFoodsEaten;
	}

	/**
	 * Sets the numOfFoodsEaten variable to the current value + amountToAdd
	 * @param amountToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void foodVisitsUp(int amountToAdd) {

		Data.player.setNumOfFoodsEaten(Data.player.getNumOfFoodsEaten() + amountToAdd);

	}

	/**
	 * The getter for the numOfQuittings variable.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int getNumOfQuittings() {
		return numOfQuittings;
	}	

	/**
	 * The setter for the numOfQuittings variable.
	 * @author foxler2010
	 * @param numOfQuittings The new value of the numOfQuittings variable
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void setNumOfQuittings(int numOfQuittings) {
		this.numOfQuittings = numOfQuittings;
	}

	/**
	 * Sets the numOfQuittings variable to the current value + quitsToAdd
	 * @param quitsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void quittingsUp(int quitsToAdd) {

		Data.player.setNumOfQuittings(Data.player.getNumOfQuittings() + quitsToAdd);

	}
	
	//INVENTORY MANAGEMENT
	
	/**
	 * Returns an item in the inventory.
	 * Does NOT remove the item from the list.
	 * @author foxler2010
	 * @param type The type of the item, in enum form.
	 * @param index The index of the item within the sub-list.
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public Item getItem(ItemType type, int index) {
		return inventory.getItem(type, index);
	}
	
	/**
	 * Adds an item to the inventory.
	 * @author foxler2010
	 * @param item The item to add to the inventory
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void addItem(Item item) {
		inventory.addItem(item);
	}
	
	/**
	 * Removes something from the inventory.
	 * Shifts everything in the sub-list down one index if the removed item is not the last index.
	 * @author foxler2010
	 * @param item The item to remove from the inventory.
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void removeItem(Item item) {
		inventory.removeItem(item);
	}

	/**
	 * Removes something from the inventory.
	 * Shifts everything in the sub-list down one index if the removed item is not the last index.
	 * @author foxler2010
	 * @param type The type of the item to remove, in enum form
	 * @param index the index of the item within the sub-list
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void removeItem(ItemType type, int index) {
		inventory.removeItem(type, index);
	}

	/**
	 * Removes something from the inventory.
	 * Shifts everything in the sub-list down one index if the removed item is not the last index.
	 * @author foxler2010
	 * @param typeIndex The index of the sublist containing the item to remove
	 * @param index The index of the item within the sublist
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void removeItem(int typeIndex, int index) {
		inventory.removeItem(typeIndex, index);
	}
	
	/**
	 * Check if the item is in the inventory.
	 * Returns either true or false.
	 * Does not specify the amount of items. (if there are multiple copies)
	 * @author foxler2010
	 * @param item The item to check for
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public boolean checkForItem(Item item) {
		return inventory.checkForItem(item);
	}
	
	/**
	 * Return the index of the inventory item specified.
	 * If item does not exist, return -1.
	 * If there are multiple copies of the item in the inventory, return the one with the lowest index.
	 * @author foxler2010
	 * @param item The item to find the index of
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int indexOfItem(Item item) {
		return inventory.indexOfItem(item);
	}
	
	/**
	 * Makes a string with the names of all items in the inventory.
	 * @author foxler2010
	 * @return A String detailing the contents of the player's inventory.
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public String inventoryToString() {
		return inventory.toString();
	}

	/**
	 * Same as inventoryToString() method, but the String lists two items as "itemName x2",
	 * instead of "itemName, itemName, etc." Almost always more useful.
	 * @author foxler2010
	 * @return A String detailing the contents of the player's inventory.
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public String inventoryFancyToString() {
		return inventory.fancyToString();
	}

	/**
	 * Returns the number of items in the inventory
	 * @author foxler2010
	 * @return The size of the player's inventory
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int sizeOfInventory() {
		return inventory.sizeOfInventory();
	}

	/**
	 * returns the number of items in the specified sublist
	 * @author foxler2010
	 * @param subListIndex The index of the sublist to return the size of.
	 * @return The size of the sublist
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int sizeOfSubList(int subListIndex) {
		return inventory.sizeOfSubList(subListIndex);
	}
	
	/**
	 * Unfinished method that will be used for combat mechanics.
	 * @author foxler2010
	 * @param target The thing you want to attack
	 * @since v1.0
	 * @see Player
	 * @see Animal
	 * @see Pet
	 * @see Monster
	 * @see Data
	 */
	public void attack(Animal target) {
		//not done yet
	}
}
