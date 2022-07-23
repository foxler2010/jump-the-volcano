package top.drewssite.volcano.data;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import top.drewssite.volcano.core.Main;
import top.drewssite.volcano.core.Options;
import top.drewssite.volcano.inventory.Inventory;
import top.drewssite.volcano.inventory.InventoryV3;
import top.drewssite.volcano.items.Bottle;
import top.drewssite.volcano.items.Food;
import top.drewssite.volcano.items.Item;
import top.drewssite.volcano.items.ItemType;
import top.drewssite.volcano.items.Junk;
import top.drewssite.volcano.items.Liquid;
import top.drewssite.volcano.items.Monster;
import top.drewssite.volcano.items.Pet;
import top.drewssite.volcano.items.Player;

/**
 * This is where all the static stuff is declared and initialized.
 * To access something in here, use the dot operator, like so: "Data.oldCanOfBeans".
 * @author foxler2010
 * @since v1.0
 * @see Main
 */
public class Data {
	
	/**
	 * This is the scanner that gets input from the player.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 * This is the pseudo-random number generator that is used by a number of methods in the codebase
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final Random random = new Random();

	/**
	 * Displays a prompt and returns user input
	 * @param prompt The prompt the player is given
	 * @return The user's input
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final String prompt(String prompt) {

		System.out.print(prompt); //display prompt

		String response = Data.scanner.next(); //get user input

		System.out.println(); //newline

		return response; //return result

	}

	/**
	 * This method prompts the user to enter one of two options (ex. yes/no question),
	 * and returns a boolean that is either true or false depending on the user input.
	 * @param prompt The prompt the player is given
	 * @param isTrue The string the player must enter for the boolean to be true
	 * @param isFalse The string the player must enter for the boolean to be false
	 * @return A boolean detailing whether the player responded yes or no
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final boolean yesNoPrompt(String prompt, String isTrue, String isFalse) {
		boolean answer = true;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			System.out.print(prompt);
			String response = Data.scanner.next();
			System.out.println();
			if(response.equals(isTrue)) {
				answer = true;
				responseIsValid = true;
			} else if(response.equals(isFalse)) {
				answer = false;
				responseIsValid = true;
			} else {
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
			}
		}
		return answer;
		
	}

	/**
	 * This method is an extension of yes/no prompt, allowing as many true and false answers as you want.
	 * @param prompt The prompt the player is given.
	 * @param isTrue The strings the player must enter for the boolean to be true.
	 * @param isFalse The strings the player must enter for the boolean to be false.
	 * @return A boolean detailing whether the player responded yes or no.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final boolean yesNoPrompt(String prompt, String[] isTrue, String[] isFalse) {
		boolean answer = true;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			System.out.println(prompt);
			String response = Data.scanner.next();
			System.out.println();
			for(int i = 0; i < isTrue.length - 1; i++) {
				if (response.equals(isTrue[i])); {
					answer = true;
				} if (response.equals(isFalse[i])) {
					answer = true;
				} else {
					System.out.println("That answer is invalid. Please try again.");
					System.out.println();
					responseIsValid = false;
				}
			}
		}
		return answer;
	}

	/**
	 * This method prompts the user to enter a string and returns true or false based on whether that string matches the isTrue parameter.
	 * @param prompt The prompt the player is given
	 * @param isTrue The string the player must enter for returned boolean to be true
	 * @return A boolean detailing whether the player entered the correct string
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final boolean stringPrompt(String prompt, String isTrue) {

		boolean answer = false;

		System.out.print(prompt);

		String response = Data.scanner.next();

		System.out.println();

		if (response.equals(isTrue)) {

			answer = true;

		} else {

			answer = false;

		}

		return answer;
		
	}

	/**
	 * This method is an extension of the regular stringPrompt() method, allowing as many true strings as needed.
	 * @param prompt The prompt the player is given
	 * @param isTrue The strings the player can enter for returned boolean to be true
	 * @return A boolean detailing whether the player entered the correct string
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final boolean stringPrompt(String prompt, ArrayList<String> isTrue) {

		boolean answer = false; //false by default

		System.out.print(prompt); //print the prompt

		String response = Data.scanner.next(); //wait for user input; store it to the var

		System.out.println(); //newline

		for(int i = 0; i < isTrue.size(); i++) { //loop thru all the true strings

			if (response.equals(isTrue.get(i))) { //if the input matches the current true string, set answer to true

				answer = true;

			}
		} //repeat for the rest of the true strings

		return answer; //true if input matches any of the true strings, otherwise it stays false

	}
	
	/**
	 * This method prompts the user to enter an integer.
	 * @param prompt The prompt the player is given.
	 * @return The integer the player entered.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static final int intPrompt(String prompt) {
		int response = 0;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			try {
				System.out.print(prompt);
				response = Data.scanner.nextInt();
				responseIsValid = true;
				System.out.println();
			} catch(InputMismatchException e) {
				System.out.println();
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
				@SuppressWarnings("unused")
				String catcher = Data.scanner.next();
			}
		}
		return response;
	}
	
	/**
	 * This method prompts the user to enter a double.
	 * @param prompt The prompt the player is given.
	 * @return The double the player entered.
	 * @author foxler2010
	 * @see Data
	 * @since v1.0
	 */
	public static final double doublePrompt(String prompt) {
		double response = 0;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			try {
				System.out.print(prompt);
				response = Data.scanner.nextDouble();
				responseIsValid = true;
				System.out.println();
			} catch(InputMismatchException e) {
				System.out.println();
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
				@SuppressWarnings("unused")
				String catcher = Data.scanner.next();
			}
		}
		return response;
	}
	
	/**
	 * Adding items to this list puts them into the player's inventory as soon as they start the game.
	 * Useful for modders.
	 * @author foxler2010
	 * @since v1.0
	 * @see Inventory
	 * @see Player
	 * @see Data
	 */
	public static InventoryV3 startingInventory = new InventoryV3(-1, new ArrayList<Item>(), new ArrayList<Integer>(), new ArrayList<ItemType>(), new ArrayList<Integer>());
	
	/*
	 * Here is where you would add items into startingInventory.
	 */
	static {
		/*
		 * Here is an example statement adding an item to startingInventory:
		 * 
		 * startingInventory.addItem(Data.oldCanOfBeans);
		 * 
		 */
	}

	private static ArrayList<Integer> visits = new ArrayList<Integer>();

	static {

		for (int i = 0; i < Options.values().length; i++) {

			visits.add(0);

		}

	}

	/**
	 * This is the player object, where all the player data is stored.
	 * @author foxler2010
	 * @since v1.0
	 * @see Player
	 * @see Data
	 */
	public static Player player = new Player("Player", 10, 0, 0, Data.startingInventory, Data.visits);
	/**
	 * The number of turns the player has taken in total throughout the whole save. Does not reset after the player dies.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static int saveTurns = 0;

	/**
	 * The number of turns the player has taken in thier current life. This resets after the player dies.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static int lifeTurns = 0;

	/**
	 * When this is true, the main loop continues to run. If the player choosesthe "Quit" option and responds yes,
	 * this boolean will be set to false.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static boolean continuingGame = true;

	/**
	 * Currently used by the "Fill Bottle" Option to check if the player is near a liquid
	 * suitable to be put inside a bottle. Right now, it is always empty.
	 * @author foxler2010
	 * @since v1.0
	 * @see Data
	 */
	public static ArrayList<Liquid> nearLiquid = new ArrayList<Liquid>();

	static {
		//add liquids the player is by in the beggining of the game here.
		//ex. if the player starts by a pond, water must be added to the list here.
		nearLiquid.add(Data.water);
	}

	public static ArrayList<Options> startingOptions = new ArrayList<Options>();

	//option code to go here

	//junk
	//index 0 in Inventory
	public static final Junk oldCanOfBeans = new Junk("Old Can of Beans", .05);
	
	public static final Junk moldySock = new Junk("Moldy Sock", .05);
	
	public static final Junk brokenMagnet = new Junk("Broken Magnet", .10);
	
	public static final Junk poopSock = new Junk("Poop Sock", 0);

	//will be changed to new class later on
	public static final Junk coolTrophy = new Junk("Cool Trophy", 100);
	//do not add to junkItems

	//list of all junks
	public static final Junk[] junkItems = {Data.oldCanOfBeans, Data.moldySock, Data.brokenMagnet, Data.poopSock};
	
	//bottles
	//stored with the junk in inventory
	public static final Bottle dirtySodaBottle = new Bottle("Dirty Soda Bottle", .05, 0, null);

	public static final Bottle freshBudLight = new Bottle("Fresh Bud Light", 10, 10, Data.budLight);

	
	//yummy things
	//index 1 in inventory
	
	public static final Food veryDietSoda = new Food("Very Diet Soda", 5.0, 5, false);

	public static final Food grannySmithApple = new Food("Granny Smith Apple", 1.0, 10, false); //ewww that apple is baaad, you only get 10 energy from it

	public static final Food honeycrispApple = new Food("Honeycrisp Apple", 2.0, 25, false); //honeycrisp is better than a granny smith

	public static final Food sweetPotatoes = new Food("Sweet Potatoes", 5.0, 50, true); //i don't actually like the taste of sweet potatoes, but they are very nutritious, so they get a lot of energy
	
	//monsters!
	//index 2 in Inventory
	public static final Monster weed = new Monster("The Weed That Keeps Popping Up In Your Garden", 1);
	
	public static final Monster slime = new Monster("Slime", 3);
	
	public static final Monster jupiterThePlanet = new Monster("Jupiter, the planet", 1000);
	
	public static final Monster zeus = new Monster("Zeus, God of Lightning", 9999);
	
	public static final Monster lightbulb = new Monster("Lightbulb", 1);
	
	public static final Monster sharpGlass = new Monster("Sharp Glass", 2);
	
	//pets!
	//index 3 in Inventory
	public static final Pet dog = new Pet("Dog", 10);
	
	public static final Pet cat = new Pet("Cat", 10);
	
	public static final Pet axolotl = new Pet("Axolotl", 20);
	
	public static final Pet rhino = new Pet("Rhino", 150);
	
	public static final Pet neilArmstrong = new Pet("Neil Armstrong", 30);

	public static final Pet gordonRamseyPlushToy = new Pet("Gordon Ramsey Plush Toy", 0);

	public static final Pet daBaby = new Pet("DaBaby", 10000000);

	//liquids
	//can't store in inventory without a Bottle, so there is no index number
	public static final Liquid water = new Liquid("Water", 0, 0, 10, true);

	public static final Liquid budLight = new Liquid("Bud Light", 10, 40, 3, true);

	//This is gonna be where the ItemDataReader is initialized for now
	//I will change it in the future.
	public static ItemDataReader reader = ItemDataReader.newInstance(Paths.get(System.getProperty("user.home"), "Documents", "code", "jump-the-volcano", "assets", "defaultData", "defaultItems.xml"));
	
}