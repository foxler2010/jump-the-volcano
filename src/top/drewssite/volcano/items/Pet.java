package top.drewssite.volcano.items;

//friendly animal
public class Pet extends Animal {
	
	public Pet(String name, int strength) {
		//same as animal, but set type to itemType.PET instead
		super(name, ItemType.PET, strength, true);
		
		//no extras to add :)
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
	public void attack(Animal target) {
		//fighting mechanics are hard.. i'll do it later
	}

}
