package top.drewssite.volcano.items;

import java.util.ArrayList;

import top.drewssite.volcano.data.Data;
import top.drewssite.volcano.inventory.InventoryV3;

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
public final class Player extends Animal {
	
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

	/** An ArrayList containing data about the amount of visits the player has made to various Options 
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	private ArrayList<Integer> visits;

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
	 * @param visits A list containing the numbers of visits the player has ade to different Options, ordred by Option index.
	 */
	public Player(String name, int strength, int level, double money, InventoryV3 startingInventory, ArrayList<Integer> visits) {
		super(name, ItemType.PLAYER, strength, false, startingInventory);
		this.level = level;
		this.money = money;
		this.visits = visits;
	}
	
	//GETTERS AND SETTERS
	
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
	 * Sets the player's balance to the current value + dollarsToAdd
	 * @param dollarsToAdd The amount of money to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */
	public void moneyUp(int dollarsToAdd) {

		Data.player.setMoney(Data.player.getMoney() + dollarsToAdd);

	}

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
	 * Sets the player's level to the current value + levelsToAdd
	 * @param levelsToAdd The amount of levels to add to the current value
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 */ 
	public void levelUp(int levelsToAdd) {

		Data.player.setLevel(Data.player.getLevel() + levelsToAdd);

	}

	public int getVisits(int index) {

		return visits.get(index);

	}
	
	public void setVisits(int index, int visits) {

		this.visits.set(index, visits);

	}

	public void visitsUp(int index) {

		this.visits.set(index, this.visits.get(index) + 1);

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
