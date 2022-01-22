/*
 * COMMENTING FORMAT!
 * 
 * ALL CAPS = new section of code
 * 
 * anything else = notes, small bits i wanted to highlight,
 * 
 * other stuff that would otherwise not make sense w/o a comment, etc.
 */


/*
 * ANSI color codes for me to use when coding
 * Red:   \u001b[31m
 * Green: \u001b[32m
 * Yellow: \u001b[33m
 * Reset: \u001b[0m
 */

package top.drewssite.volcano;
import java.util.*;

/**
 * This is where the main method is located. When the program starts, the methods in here are executed.
 * @author foxler2010
 * @since v1.0
 * @see Utility
 * @see Data
 */
class Main {
	
	//Useful stuff
	private static Utility utilities = new Utility();
	
	/**
	 * This is the main method. When the program is executed, this is the method that is called
	 * @param args Arguments from the shell. Currently not used for anything, but that could change.
	 */
	public static void main(String args[]) {
		
		//WELCOME THE PLAYER TO THE GAME
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Welcome to Jump The Volcano!");
		System.out.println();
		
		//MAKE PLAYER
		Player player = new Player("Player", 10, 0, 0, Data.startingInventory);
		
		//MAKE OPTIONS
		String jumpTheVolcano = "Jump The Volcano";
		String dumpsterDive = "Dumpster dive";
		String petStore = "Go to the Pet Store (level+1)";
		String arena = "Visit the Arena (inventory+1canOfBeans)";
		String quit = "Exit the game";
		
		//MAKE RANDOM
		Random random = new Random();
		
		//LET'S START THE GAME!
		System.out.println("Your level is \u001b[32m" + player.getLevel() + "\u001b[0m and you have $\u001b[31m" + player.getMoney() + "\u001b[0m in your wallet.");
		System.out.println();
		System.out.println("Let's get started with the game!");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();

		//SET firstTurn TO TRUE
		//the next loop will be the first turn of the game, so this must be true.
		boolean firstTurn = true;
		
		/*
		 * MAIN LOOP STARTS HERE
		 * 
		 * Structure of it:
		 * 
		 * PHASE 1: Report info to the player on their level, balance, and important inventory items (DONE!)	
		 * PHASE 2: Prompt them on what they would like to do. This prompt has different choices every time (DONE!)
		 * PHASE 3: Carry out the action. changing the player's instance vars along the way. This is the only step where the vars are changed.
		 * PHASE 4: Repeat from step 1, starting a new turn
		 */
		
		//initialize boolean to track whether we are continuing the loop or not
		//also make a turn counter because it's useful
		boolean continuingGame = true;
		int turns = 0;
		//the loop begins
		while (continuingGame) {
			//PHASE 1
			//reported no matter what
			System.out.println("Turn: \u001b[33m" + turns + "\u001b[0m");

			//only displayed on turn >2
			if (!firstTurn) {
				System.out.println("Your level is \u001b[32m" + player.getLevel() + "\u001b[0m...\n...and you have $\u001b[31m" + player.getMoney() + "\u001b[0m in your wallet.");
			}

			System.out.println();
			
			//view inventory?
			if(utilities.yesNoPrompt("Would you like to view your inventory? [y/n] ", "y", "n")) {

				//check for emptiness
				if(player.sizeOfInventory() == 0) {

					System.out.println("You inventory is currently empty.");

				} else {

					System.out.println("Here it is:");
					System.out.println();

					System.out.print(player.inventoryFancyToString()); //workhorse command, does majority of the work

					//newline for readability
					System.out.println();

				}//end sizechecking if

			} else {

				System.out.println("Okay, let's keep going...");

			}//end inventory shenanigans

			//NEWLINE FOR READABILITY
			System.out.println();
			
			//PHASE 2
			//all possible options here. currently they are manually activated but that is going to change.
			//to activate an option simply add it to the 'availableOptions' list
			
			//the 'jumpTheVolcano' option is ALWAYS active so the line adding it to the list will always be here.
			//the others will be active depending on some algorithms that are yet to be coded.
			ArrayList<String> availableOptions = new ArrayList<String>();
			availableOptions.add(jumpTheVolcano);
			availableOptions.add(dumpsterDive);
			availableOptions.add(petStore);
			availableOptions.add(arena);
			availableOptions.add(quit);
			
			//I have to declare and initialize these outside of the phase 2 loop.
			//I initialized them with 'jumpTheVolcano' because it is the one option that will always be displayed.
			//There is no way they could possibly exit the phase 2 loop without being assigned to a new option
			//so it is okay to choose any option here
			String option1 = jumpTheVolcano;
			String option2 = jumpTheVolcano;
			String option3 = jumpTheVolcano;
			String option4 = jumpTheVolcano;
			String option5 = jumpTheVolcano;
			
			System.out.println("Here are your options for this turn:");
			System.out.println();
			
			//this loop actually displays and assigns every available option to a new(-ish) var which will be useful later.
			for(int currentOption = 0; currentOption < availableOptions.size(); currentOption++) {
				
				//set whatever option is listed at this number as the option for this number
				//a bit confusing but it is extremely important in order to run the right code when an
				//option is chosen
				switch(currentOption) {
				
				case 0: option1 = availableOptions.get(currentOption);
						break;
				case 1: option2 = availableOptions.get(currentOption);
						break;
				case 2: option3 = availableOptions.get(currentOption);
						break;
				case 3: option4 = availableOptions.get(currentOption);
						break;
				case 4: option5 = availableOptions.get(currentOption);
				}//end switch
				
				//print the option to the screen. and do some cool maths so the numbers are always in ascending order :)
				System.out.println("  " + (currentOption + 1) + ") " + availableOptions.get(currentOption));
				
				}//end phase2 loop
			
			//newline for readability
			System.out.println();
			//initialize this var with 'jumpTheVolcano' because that's what I've been using for all
			//option-related initializations
			String chosenOption = jumpTheVolcano;
			//assign 'choosenOption' to the correct value based on the users choice.
			boolean responseIsValid = false;
			while(responseIsValid == false) {
				
				//prompts the user to choose an option
				//arguably the most important line in the game
				int option = utilities.intPrompt("Please input the option you would like to carry out: ");
				
				//the following switch converts a # to a String
				//It uses the 'option1', 'option2', etc vars because they are guaranteed to match the # chosen.
				//the actual Strings declared at the beginning of the main method are not assigned a #.
				//the 'option1' vars are "hard-coded" with a number,
				//so when the actual options are displayed on-screen they
				//are assigned a number by being given an 'alias' of sorts through the 'option1' vars.
				//then when the user chooses an option, a new String var is created to signify the users choice ('chosenOption')
				//in String form instead of int form (option). So overall this a just a bunch of code that just moves vars
				//and their values all over the place
				
				//I hope that was a good enough explanation of phase 2, now on with the code
				
				switch(option) {
				
				case 1: chosenOption = option1;
						responseIsValid = true;
						break;
				case 2: chosenOption = option2;
						responseIsValid = true;
						break;
				case 3: chosenOption = option3;
						responseIsValid = true;
						break;
				case 4: chosenOption = option4;
						responseIsValid = true;
						break;
				case 5: chosenOption = option5;
						responseIsValid = true;
						break;
				default: System.out.println("That answer is invalid. Please try again.");
						 System.out.println();
				
				}//end switch
			}//end while
			
			//and finally, after all that jazz...
			System.out.println("You choose " + chosenOption);
			System.out.println();
			//we can use the chosen value to do stuff
			
			
			//PHASE 3
			//contains code for what to do no matter what option is chosen.
			
			//if you try to jump the volcano
			if(chosenOption == jumpTheVolcano) {
				//gen random boolean to decide between whether you successfully jump the volcano or not.
				if(random.nextInt(101) > 79) {
					System.out.println("You jump over the volcano");
				} else {
					System.out.println("You fall into the volcano and die. *in the distance trombone sounds* Wah wah wahhhhh.");
					System.out.println();
					//oh no you have to restart
					player.setHealth(0);
				}
			}//end jump the volcano if
			
			//you dive into the dumpster in search of random items people threw away
			if(chosenOption == dumpsterDive) {
				//choose random item from list of items that are in the dumpster
				Junk randomJunk = Data.junkItems[random.nextInt(Data.junkItems.length)];
				//add it to player's inventory
				player.addItem(randomJunk);
				//tell player what they got
				System.out.println("You got a " + randomJunk.getName());
				System.out.println();
			}//end dumpster dive if
			
			if(chosenOption == petStore) {
				System.out.println("test, level+1");
				player.setLevel(player.getLevel() + 1);
			}//end pet store if
			
			if(chosenOption == arena) {
				System.out.println("test, inventory+oldCanOfBeans");
				try {
					player.addItem(Data.oldCanOfBeans);
				} catch(NullPointerException e) {
					
				}
			}//end arena if
			
			if(chosenOption == quit) {
				continuingGame = utilities.yesNoPrompt("Do you want to continue playing? [y/n] ", "y", "n");
			}//end quit if
			
			//HEALTHCHECK
			if(player.getHealth() == 0) {
				System.out.println("It seems you have died. Agoostafus, the angel of ressurection,\nhas offered to ressurect you, but you must lose all your earthly\npossesions and start life from the beggining again.");
				System.out.println();
				continuingGame = utilities.yesNoPrompt("Do you accept Agoostafus' offer? [y/n] ", "y", "n");
				if(continuingGame) {
					System.out.println("Okay, please standby. You will be ressurected shortly.");
					System.out.println();
					player.setMoney(0);
					player.setLevel(0);
					player.setHealth(100);
					//clear inventory
					for (int i = 0; i <= 6; i++) {
						for (int j = 0; j < player.sizeOfSubList(i); j++) {
							player.removeItem(i, j);
						}
					}
				} else {
					System.out.println("Too bad. I thought it was a good deal, but I guess it is your call...");
					System.out.println("Have fun dying.");
					System.out.println();
					System.out.println("--------------------------------------------------------------------------");
					System.out.println();
				}//end resurrection if-else
			}//end healthcheck
			
			if(continuingGame) {
				//MARKS END OF TURN
				//only shown if you didn't quit or if you die.
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
			}//end turnmarker if
			
			//Increase turn counter by one at end of turn
			turns++;
			
		}//end main loop
		
		
		
		//ENDGAME
		System.out.println("Thank you for playing Jump The Volcano. Please play again soon!");
		
		//CLOSE SCANNER
		utilities.getScanner().close();
		
	}//end main method
}//end main class
