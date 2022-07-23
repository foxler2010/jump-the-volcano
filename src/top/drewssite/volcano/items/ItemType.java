package top.drewssite.volcano.items;

import java.util.ArrayList;

//this is one way to find out what an item 'is'.
//combined with the inheritance structure of items, categorization should be very easy
public enum ItemType {

	PLAYER("Player", 0),
	PET("Pet", 1, "name", "strength") {

		@Override
		public Item construct(ArrayList<String> args) {

			int strength = Integer.parseInt(args.get(1));

			return new Pet(args.get(0), strength);

		}

	},

	MONSTER("Monster", 2, "name", "strength") {

		@Override
		public Item construct(ArrayList<String> args) {

			int strength = Integer.parseInt(args.get(1));

			return new Monster(args.get(0), strength);

		}

	},

	JUNK("Junk", 3, "name", "price") {

		@Override
		public Item construct(ArrayList<String> args) {

			double price = Double.parseDouble(args.get(1));

			return new Junk(args.get(0), price);

		}

	},

	FOOD("Food", 4, "name", "price", "energy", "cookable", "cooked") {

		@Override
		public Item construct(ArrayList<String> args) {

			double price = Double.parseDouble(args.get(1));

			int energy = Integer.parseInt(args.get(2));

			boolean cookable = Boolean.parseBoolean(args.get(3));

			if (args.size() == 5 && args.get(3) == "true") {

				boolean cooked = Boolean.parseBoolean(args.get(4));

				try {

					return new Food(args.get(0), price, energy, cookable, cooked);
					
				} catch (FoodUncookableException e) {

					e.printStackTrace();

				}

			}

			return new Food(args.get(0), price, energy, cookable);

		}

	},
	BOTTLE("Bottle", 5), //added
	LIQUID("Liquid", 6),
	KIT("Kit", 7),
	WEAPON("Weapon", 8),
	TROPHY("Trophy", 9), //added
	OTHER("Other", 10, "name") {

		@Override
		public Item construct(ArrayList<String> args) {

			return new Other(args.get(0));

		}

	}; 

	private String name;

	private int index;

	private final ArrayList<String> args;

	/** Constructs a new value for ItemType
	 * @author foxler2010
	 * @param name The name of the ItemType. Usually just the enum name but not all caps
	 * @param index A unique number for the enum value. This CANNOT be the same as any other enum values' indexes.
	 * @param args The arguments required to create an item of this type
	 * @since v1.0
	 * @see ItemType
	 */
	private ItemType(String name, int index, String... args) {

		this.name = name;

		this.index = index;

		this.args = new ArrayList<String>();

		for (int i = 0; i < args.length; i++) {

			this.args.add(args[i]);

		}

	}

	/**
	 * Returns a list with the names of the arguments that the Item's constructor needs to make a new Item.
	 * The XML parser uses this info to figure out where in the list to place its information when building a new Item.
	 * That list is given to the construct() method which then extracts the data from the list in a speciified order, giving it to the actual constructor
	 * The construct() method then returns the created Item.
	 * @author foxler2010
	 * @return A list of the names of the Item's constructor's arguments in order
	 * @since v1.0
	 * @see ItemType
	 */
	public ArrayList<String> getArgs() {

		return args;

	}

	/** 
	 * Organizes the arguments given to it according to the type of item being created,
	 * and then sends those arguments to the Item's constructor, returning the resulting Item.
	 * The arguments given MUST be in the right order or the Item constructor will not work or the Item will not match its XML data.
	 * The order is specified in the getArgs() method.
	 * @author foxler2010
	 * @throws ConstructorNotDefinedException
	 * @since v1.0
	 * @see ItemType
	 */
	public Item construct(ArrayList<String> args) throws ConstructorNotDefinedException {

		System.out.println("ERROR: The " + this.getName() + " item type does not have a construct() method defined in ItemType!");
		
		throw new ConstructorNotDefinedException(this.getName());

	}

	/** Returns the enum values' name
	 * @author foxler2010
	 * @since v1.0
	 * @see ItemType
	 */
	public String getName() {

		return name;

	}

	/** Sets the enum values' name
	 * @author foxler2010
	 * @param name The new name
	 * @since v1.0
	 * @see ItemType
	 */
	public void setName(String name) {

		this.name = name;

	}

	/** Returns the enum values' index
	 * @author foxler2010
	 * @since v1.0
	 * @see ItemType
	 */
	public int getIndex() {

		return index;

	}

	/** Sets the enum values' index
	 * @author foxler2010
	 * @param name The new index
	 * @since v1.0
	 * @see ItemType
	 */
	public void setIndex(int index) {

		this.index = index;

	}

};

