package top.drewssite.volcano.items;

import java.util.ArrayList;

import top.drewssite.volcano.inventory.InventoryV3;

/**
 * friendly animal
 * @author foxler2010
 * @since v1.0
 * @see Animal
 */
public class Pet extends Animal {
	
	/**
	 * Constructs a new Pet
	 * @author foxler2010
	 * @param name the name of the Pet
	 * @param strength How strong the Pet is
	 * @since v1.0
	 * @see Animal
	 */
	public Pet(String name, int strength) {
		//same as animal, but set type to itemType.PET instead
		super(name, ItemType.PET, strength, true, new InventoryV3(-1, new ArrayList<Item>(), new ArrayList<Integer>(), new ArrayList<ItemType>(), new ArrayList<Integer>()));
		
		//no extras to add :)
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
	public void attack(Animal target) {
		//fighting mechanics are hard.. i'll do it later
	}

}
