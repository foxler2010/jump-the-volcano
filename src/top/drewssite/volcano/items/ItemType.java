package top.drewssite.volcano.items;

//this is one way to find out what an item 'is'.
//combined with the inheritance structure of items, categorization should be very easy
public enum ItemType {
	//below could be considered a roadmap of all types of items that are,
	//or will be added to the game
	MONSTER("Monster"), //added!
	PET("Pet"), //added!
	KIT("Kit"),
	WEAPON("Weapon"),
	JUNK("Junk"), //added
	FOOD("Food"), //added
	PLAYER("Player"),
	TROPHY("Trophy"),
	BOTTLE("Bottle");

	private String name;

	private ItemType(String name) {

		this.name = name;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

};

