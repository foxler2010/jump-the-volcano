package top.drewssite.volcano;

//it's an item that is alive
//it also has some extra alive-stuff-only attributes (health, strength, etc)
public abstract class Animal extends Item {

	//VAR
	private int strength;
	private int health;
	
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
	public Animal(String name, ItemType type, int strength, boolean important) {
		
		super(name, type, important);
		
		//don't forget about the new animal-only stuff
		this.strength = strength;
		this.health = 100;
	}


	//stub method, not complete
	/**
	 * Allows the Animal calling the method to "eat" things.
	 * The method grabs info from a given Food item and chamges the Animal's values accordingly.
	 * A good Food item will provide the Animal with the amount of energy the Food would provide in real life.
	 * To make sure this method affects the Animal's values correctly, make sure any Food items you create have the appropriate values.
	 * @author foxler2010
	 * @param food The food to eat
	 * @return The amount of health recieved by eating the food.
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public int eat(Food food) {


		
	}

	/**
	 * Unfinished method that will be used for comat mechanics.
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
