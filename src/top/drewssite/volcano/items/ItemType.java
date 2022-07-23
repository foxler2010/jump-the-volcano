package top.drewssite.volcano.items;

import java.util.ArrayList;

import top.drewssite.volcano.data.Data;
import top.drewssite.volcano.data.ItemNotFoundException;

/** This enum's job is to help identify Items. 
 * Every Item has one of these enums as a property,
 * and usually the enum is hardcoded to a certain value using the subclass' constructor.
 * For example, in the constructor for Pets, the super() call has ItemType.PET listed as an argument.
 * This makes all Pets have the same ItemType. The enum itself has a few properties of its own.
 * Here is a description of each:
 * <ul>
 * <li>
 * <p>
 * Name: This is the name of the enum, in an easy-to-read format that can be displayed to players.
 * </p>
 * </li>
 * <li>
 * <p>
 * Index: This is a number which is unique to every enum value. In the game's XML data files, this number is used to identify what type an item is.
 * It's very important that the item data, enum value, and class file all match up or else some bad things will happen.
 * </p>
 * </li>
 * <li>
 * <p>
 * Args: This is a String vararg, so in the constructor call for the enum value, you can put in any number of strings after the index and they will all be sent to the constructor as an arrayof Strings.
 * The intended purpose of this list is to store the arguments needed to create an Item of that type.
 * In the class file for a given type, the constructor takes in a unique set of arguments to build an Item.
 * These arguments MUST be in order in the enum value or the XML parser will not put the Item's properties in the right order and the constructor will not work.
 * This concept of putting the arguments in order in the enum is explained in much more detail in the mod developer documentation.
 * </p>
 * </li>
 * <li>
 * <p>
 * The construct() method: This method is extremely important as it allows for the XML parser to create new Items without needing to store the data about every type.
 * The default version of this method throws an exception since the only reason it would get called is if the enum value does not have its own version of the method, which it needs to.
 * The override versions of the method take an ArrayList<String> containing the Item's unique arguments, and unpack it/cast it into the correct data types that the constructor expects.
 * Then the data, now in the right format, travels into the constructor where it is constructed into an Item, which is returned.
 * The XML parser recieves this newly minted Item and returns it, completing its task.
 * Like the args list and index, this method is explained in more detail and in an easier to understand way in the mod developer documentation, found on my website (https://docs.jump-the-volcano.drewssite.top)
 * </ul>
 * 
 * @author foxler2010
 * @since v1.0
 * @see Item
 */
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
	BOTTLE("Bottle", 5, "name", "price", "fullness", "contents") {

		@Override
		public Item construct(ArrayList<String> args) throws ConstructorNotDefinedException, ItemNotFoundException {

			double price = Double.parseDouble(args.get(1));

			if (args.size() == 4) {

				int fullness = Integer.parseInt(args.get(2));
	
				Liquid contents = (Liquid) Data.reader.getItem(args.get(3));

				return new Bottle(args.get(0), price, fullness, contents);

			}

			return new Bottle(args.get(0), price);

		}

	},
	LIQUID("Liquid", 6, "name", "price", "energy", "hydration", "isBottleable") {

		@Override
		public Item construct(ArrayList<String> args) {

			double price = Double.parseDouble(args.get(1));

			int energy = Integer.parseInt(args.get(2));

			int hydration = Integer.parseInt(args.get(3));

			boolean isBottleable = Boolean.parseBoolean(args.get(4));

			return new Liquid(args.get(0), price, energy, hydration, isBottleable);

		}

	},
	// KIT("Kit", 7), //not yet implemented
	// WEAPON("Weapon", 8), //not yet implemented
	TROPHY("Trophy", 9, "name", "price") {

		@Override
		public Item construct(ArrayList<String> args) {

			double price = Double.parseDouble(args.get(1));

			return new Junk(args.get(0), price);

		}

	}, //added
	MISCELLANEOUS("Other", 10, "name") {

		@Override
		public Item construct(ArrayList<String> args) {

			return new Miscellaneous(args.get(0));

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
	 * @throws ItemNotFoundException
	 * @since v1.0
	 * @see ItemType
	 */
	public Item construct(ArrayList<String> args) throws ConstructorNotDefinedException, ItemNotFoundException {

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

