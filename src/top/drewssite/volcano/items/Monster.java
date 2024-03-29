package top.drewssite.volcano.items;

import java.util.ArrayList;

import top.drewssite.volcano.inventory.Inventory;

/**
 * unfriendly animal.. pretty much exactly the same as pet
 * @author foxler2010
 * @since v1.0
 * @see Animal
 */
public class Monster extends Animal {

	/** Constructs a new monster
	 * @author foxler2010
	 * @param name The name of the Monster
	 * @param strength How strong the Monster is
	 * @since v1.0
	 * @see Monster
	 */
	public Monster(String name, int strength) {
		//same as animal, but set type to itemType.MONSTER instead
		super(name, ItemType.MONSTER, strength, false, new Inventory(-1, new ArrayList<Item>(), new ArrayList<Integer>(), new ArrayList<ItemType>(), new ArrayList<Integer>()));
		
		//no extras to add :)
	}
	
	/**
	 * Unfinished method that will be used for combat mechanics.
	 * @author foxler2010
	 * @param target The thing you want to attack
	 * @since v1.0
	 * @see Monster
	 * @see Player
	 * @see Pet
	 * @see Animal
	 */
	public void attack(Animal target) {
		//fighting mechanics are hard.. i'll do it later
	}

}
