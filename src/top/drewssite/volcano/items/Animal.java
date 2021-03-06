package top.drewssite.volcano.items;

import top.drewssite.volcano.data.Data;
import top.drewssite.volcano.inventory.InventoryV3;

//it's an item that is alive
//it also has some extra alive-stuff-only attributes (health, strength, etc)
public abstract class Animal extends Item {

	/** The strength of the Animal
	 * @author foxler2010
	 * @since v1.0
	 * @see Animal
	 */
	private int strength;

	/** The health of the animal. If it's zero they will die by the end of the turn
	 * @author foxler2010
	 * @since v1.0
	 * @see Animal
	 */
	private int health;

	/**
	 * The Inventory object storing all the items in the animal's possesion
	 * @author foxler2010
	 * @since v1.0
	 * @see Animal
	 */
	
	private InventoryV3 inventory;
	
	//GETTERS AND SETTERS
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		//big attacks don't give you negative health
		if (health >= 0) {
			this.health = health;
		} else {
			this.health = 0;
		}
	}
	
	//CONSTRUCTOR takes in name, price, and type
	public Animal(String name, ItemType type, int strength, boolean important, InventoryV3 inventoryV3) {
		
		super(name, type, important);
		
		//don't forget about the new animal-only stuff
		this.strength = strength;
		this.health = 100;
		this.inventory = inventoryV3;
	}


	//stub method, not complete
	/**
	 * Allows the Animal calling the method to "eat" things.
	 * The method grabs info from a given Food item and chamges the Animal's values accordingly.
	 * A good Food item will provide the Animal with the amount of energy the Food would provide in real life.
	 * To make sure this method affects the Animal's values correctly, make sure any Food items you create have the appropriate values.
	 * @author foxler2010
	 * @param food The food to eat
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public void eat(Food food) {

		int foodEnergy = food.getEnergy(); //get the amount of energy the food provides

		Data.player.setHealth(Data.player.getHealth() + foodEnergy); //increase health by the amount of energy the food provides

		int extraEnergy = 100 - Data.player.getHealth(); //max health is 100, so anything above is extra. calculate extra energy and store it to a var

		Data.player.setHealth(Data.player.getHealth() - extraEnergy); //subtract the extra emergy from the health so we stay at the max of 100 health

		Data.player.setStrength(Data.player.getStrength() + extraEnergy); //extra energy increases the player's strength. anything that didn't go to healing the player goes to strengthening them.
		
	}

	/** Returns the animal's inventory.
	 * @return The animal's inventory
	 * @author foxler2010
	 * @since v1.0
	 * @see Animal
	 */
	public InventoryV3 getInventory() {

		return inventory;

	}

	/**
	 * Unfinished method that will be used for combat mechanics.
	 * @author foxler2010
	 * @param target The thing you want to attack
	 * @since v1.0
	 * @see Animal
	 * @see Monster
	 * @see Pet
	 * @see Player
	 */
	public abstract void attack(Animal target);
	
}
