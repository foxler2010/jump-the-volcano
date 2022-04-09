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

import java.util.ArrayList;

/**
 * This is where the main method is located. When the program starts, the methods in here are executed.
 * @author foxler2010
 * @since v1.0
 * @see Data
 * @see Data
 */
class Main {
	
	/**
	 * This is the main method. When the program is executed, this is the method that is called.
	 * 
	 * @param args Arguments from the shell. Currently not used for anything, but that could change.
	 */
	public static void main(String args[]) {
		
		//I need to put this somewhere in the beginning of main(). It will be removed later when I make the new factory system.
		Data.addJunksToList();
		
		//WELCOME THE PLAYER TO THE GAME
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Welcome to Jump The Volcano!");
		System.out.println();
		
		//LET'S START THE GAME!
		System.out.println("Your level is \u001b[32m" + Data.player.getLevel() + "\u001b[0m and you have $\u001b[31m" + Data.player.getMoney() + "\u001b[0m in your wallet.");
		System.out.println();
		System.out.println("Let's get started with the game!");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
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
		Data.turns = 0;

		//the loop begins
		while (Data.continuingGame) {
			//PHASE 1
			//reported no matter what
			System.out.println("Turn: \u001b[33m" + Data.turns + "\u001b[0m");
			System.out.println("Your level is \u001b[32m" + Data.player.getLevel() + "\u001b[0m...\n...and you have $\u001b[31m" + Data.player.getMoney() + "\u001b[0m in your wallet.");
			System.out.println();
			
			//view inventory?
			if(Data.yesNoPrompt("Would you like to view your inventory? [y/n] ", "y", "n")) {

				//check for emptiness
				if(Data.player.sizeOfInventory() == 0) {

					System.out.println("You inventory is currently empty.");

				} else {

					System.out.println("Here it is:");
					System.out.println();

					System.out.print(Data.player.inventoryFancyToString()); //workhorse command, does majority of the work

					//newline for readability
					System.out.println();

				}

			} else {

				System.out.println("Okay, let's keep going...");

			}

			//NEWLINE FOR READABILITY
			System.out.println();
			
			//PHASE 2
			//display options

			//determine availability of options
			ArrayList<Option> availableOptions = new ArrayList<Option>();

			//loop thru every option that exists
			for (int i = 0; i < Option.values().length; i++) { //uses Option.values(), which returns an Option[] containing all values in Option.

				//if the option we are looping through is currently available to the player, add it to the list.
				if (Option.values()[i].isAvailable()) {

					availableOptions.add(Option.values()[i]);

				}

			}
			
			//display options to the player
			System.out.println("Here are your options for this turn:");
			System.out.println();
			
			//this loop displays the options
			for (int i = 0; i < availableOptions.size(); i++) {
				
				//print the option to the screen. and do some cool maths so the numbers are always starting at 1 :)
				System.out.println("  " + (i + 1) + ") " + availableOptions.get(i).getName());
				
			}
			
			//newline for readability
			System.out.println();
			
			//PHASE 3
			//choose options and change player stats

			boolean responseIsValid = false;

			while(responseIsValid == false) {
				
				//prompts the user to choose an option
				//this is where the user puts in what they want to do every turn
				int option = Data.intPrompt("Please input the option you would like to carry out: ");
				
				//if user input is an index in the list
				//loop thru and find out which index the user input is
				if (option <= availableOptions.size() && option > 0) {
					
					for (int i = 0; i < availableOptions.size(); i++) {
						
						if (option == i + 1) { // +1 is because user input will be 1 greater than the index
							
							//lets player know what they chose
							System.out.println("You chose " + availableOptions.get(i).getName());
							System.out.println();

							//executes the option's opCode() method
							//this is the ONLY time player stats EVER change!!!
							availableOptions.get(i).opCode();

							//ends the while loop
							responseIsValid = true;

						}

					}

				} else { //if user input is out of bounds
					
					System.out.println("That answer is invalid. Please try again.");
					System.out.println();

					//makes loop run again
					responseIsValid= false;

				}

			}
			
			//HEALTHCHECK
			if(Data.player.getHealth() == 0) {
				System.out.println("Your health is at 0. It seems you have died. You start contemplating your life choices, when\na powerful, heavenly goose flies toward you crashing into the *insert random physical object* next to you. The goose has offered to ressurect you,\nbut you must lose all your earthly posessions and start life from the beggining again.");
				System.out.println();
				Data.continuingGame = Data.yesNoPrompt("Do you accept the goose's offer? [y/n] ", "y", "n");
				if(Data.continuingGame) {
					System.out.println("Okay, please standby. You will be ressurected shortly.");
					System.out.println();
					Data.player.setMoney(0);
					Data.player.setLevel(0);
					Data.player.setHealth(100);

					//clear inventory
					//does NOT restore starting inventory. maybe that will be toggleable in the future
					for (int i = 0; i < 7; i++) {

						for (int j = 0; j < Data.player.sizeOfSubList(i); j++) {

							Data.player.removeItem(i, j);

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
			
			if(Data.continuingGame) {
				//MARKS END OF TURN
				//only shown if you didn't quit or if you die.
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
			}//end turnmarker if
			
			//Increase turn counter by one at end of turn
			Data.turns++;
			
		}//end main loop	
		
		//ENDGAME
		System.out.println("Thank you for playing Jump The Volcano. Please play again soon!");

		//CLOSE SCANNER
		Data.scanner.close();
		
	}//end main method
}//end main class
