package top.drewssite.volcano;

import java.util.ArrayList; //used in FILL_BOTTLE option, which is currently commented

/**
 * Here is where all the options and their code is stored. I am putting option docs here as I don't have anywhere else to put them for now.
 * 
 * Note: Docs look better inside the Option.java file, go jump to it instead of reading the little pop-up
 * vscode gives you when you hover over terms. Then you can see the line breaks I typed.
 * 
 * To make a new option, add a new enum constant to the list below and put its fancy name in parentheses,
 * along with the code for the option in a method called "opCode()",
 * which should be located in brackets as part of the enum constant.
 * 
 * To dynamically show your option based on the state of the game, add an isAvailable() method below your opCode() method.
 * This method should return true when it is okay to show the option, and return false when the option should not be shown.
 * An example of the use of this is the "Dumpster Dive" option. It is only available when you have less than 10 items.
 * 
 * After making your option and adding it to the main method, you will have to recompile
 * the game. If you are using a locally installed JRE to run the game after compilation, this will not take long.
 * If you would like a system binary (Grants the ability to run the game without installing a Java runtime),
 * you will have to use some extra tools and things and do it manually, as I have not written a Gradle build script
 * to do it for me.
 * 
 * I will have documentation for how I do it soon.
 * 
 * @author foxler2010
 * @since v1.0
 * @see Main
 * @see Data
 */
public enum Option {
    
    /**
     * This is the code for the "Jump the Volcano" option you get every turn.
     * 
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     * @see Main
     */
    JUMP_THE_VOLCANO("Jump the Volcano") {

        @Override
        public void opCode() {

            //increase # of visits by 1
            Data.player.volcanoVisitsUp(1);

            //gen random boolean to decide between whether you successfully jump the volcano or not.
            //10% chance of success per attempt
			if(Data.random.nextInt(100) >= 90) { //success: # between 0 and 99, 10/100 return true = 10%

				System.out.println("You jump over the volcano");
                Data.player.setLevel(Data.player.getLevel() + 100);

                if (Data.random.nextInt(100) >= 70) { //30% chance within the 10% chance

                    System.out.println("Everybody is really impressed with your volcano-jumping skills");
                    System.out.println("They give you $1000 and a cool trophy as a prize for jumping the volcano.");
                    Data.player.setMoney(Data.player.getMoney() + 1000);
                    Data.player.addItem(Data.coolTrophy);
                    for (int i = 0; i < Data.player.sizeOfSubList(0); i++) {

                        if (Data.player.getItem(ItemType.JUNK, i).getName() == Data.coolTrophy.getName()) {

                            Data.player.getItem(ItemType.JUNK, i).setName("Volcano Jumping Trophy");

                        }

                    }

                }

			} else {

				System.out.println("You fall into the volcano and die. *in the distance trombone sounds* Wah wah wahhhhh.");
				System.out.println();

				//oh no you have to restart
				Data.player.setHealth(0);

			}

        }

        @Override
        public boolean isAvailable() {
            return true;
        }

    },

    /**
     * This is the code for the "Dumpster Dive" option you get when you have a small amount of items.
     * 
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     * @see Main
     */
    DUMPSTER_DIVE("Dumpster Dive") {

        @Override
        public void opCode() {

            //increase # of visits by 1
            Data.player.dumpsterVisitsUp(1);

            //choose random item from list of items that are in the dumpster
		    Junk randomJunk = Data.junkItems[Data.random.nextInt(Data.junkItems.length)];

		    //add it to player's inventory
		    Data.player.addItem(randomJunk);

		    //tell player what they got
		    System.out.println("You got a " + randomJunk.getName());
		    System.out.println();

        }

        @Override
        public boolean isAvailable() {
            if (Data.player.sizeOfInventory() < 10) {
                return true;
            } else {
                return false;
            }
        }

    },

    SHOP("Go to the Shop") {
        
        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.shopVisitsUp(1);

            System.out.println("You visit the shop and sell nothing because you are a hoarder.");
            
        }
        
        @Override
        public boolean isAvailable() {
            if (Data.player.sizeOfInventory() >= 5 || Data.player.getMoney() >= 1) {
                return true;
            } else {
                return false;
            }
        }
    },

    PET_STORE("Go to the Pet Store") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.petStoreVisitsUp(1);

        }

        @Override
        public boolean isAvailable() {
            if (Data.player.getMoney() >= 500) {
                return true;
            } else {
                return false;
            }
        }
        
    },

    ARENA("Visit the Arena") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.arenaVisitsUp(1);

        }

        @Override
        public boolean isAvailable() {
            if (Data.saveTurns >= 50) {
                return true;
            } else {
                return false;
            }
        }
        
    },

    EAT_FOOD("Eat some food") {

        @Override
        public void opCode() {

            Data.player.foodVisitsUp(1);

            int amountOfFood = Data.player.sizeOfSubList(1);

            Food chosenFood = null;
            
            if (amountOfFood > 1) {
    
                System.out.println("You have " + amountOfFood + " pieces of food: ");
    
                for (int i = 0; i < amountOfFood; i++) {
        
                    System.out.println((i + 1) + ") " + Data.player.getItem(ItemType.FOOD, i).getName());
        
                }
    
                int playerInput = Data.intPrompt("Which food item would you like to eat? ");
    
                for (int i = 0; i < amountOfFood; i++) {
    
                    if (playerInput == i - 1) {

                        chosenFood = (Food) Data.player.getItem(ItemType.FOOD, (i - 1));

                    }
    
                }

            } else {
    
                System.out.println("You have 1 " + Data.player.getItem(ItemType.FOOD, 0).getName());
                System.out.println();
                if (Data.yesNoPrompt("Would you like to eat it? [y/n] ", "y", "n")) {

                    chosenFood = (Food) Data.player.getItem(ItemType.FOOD, 0);

                }
    
            }

            Data.player.eat(chosenFood);
    
        }

        @Override
        public boolean isAvailable() {
            
            if(Data.player.sizeOfSubList(1) > 0) {
            
                return true;
            
            }

            return false;

        }

    },

    // broken option
    // FILL_BOTTLE("Fill Bottle") {

    //     @Override
    //     public void opCode() {
            
    //         boolean multipleBottles; //if there is more than one bottle or not
    //         ArrayList<Bottle> bottlesInInventory = new ArrayList<Bottle>(); //output of loop
    //         Item currentItem; //used only inside loop
    //         for (int i = 0; i < Data.player.sizeOfSubList(0); i++) { //loop counts how many bottles you have

    //             currentItem = Data.player.getItem(ItemType.JUNK, i);

    //             if (currentItem.getClass() == Bottle.class) {

    //                 bottlesInInventory.add((Bottle) currentItem); /* currentItem will always be assigned to a Bottle here,
    //                                                                * but we still need to cast because the
    //             }                                                  * variable type is an Item. */

    //         }

    //         //multipleBottles is set to true if the bottlesInInventory list has more than one item in it
    //         if (bottlesInInventory.size() > 1) {
    //             multipleBottles = true;
    //         }

    //         System.out.println("You are currently able to fill your bottle with " + Data.nearLiquid.size() + " liquids near you");
    //         System.out.println();
    //         System.out.println("Here they are:");

    //         for (int i = 0; i < Data.nearLiquid.size(); i++) {

    //             System.out.println((i + 1) + ") " + Data.nearLiquid.get(i).getName());                    

    //         }

    //         int liquid = Data.intPrompt("Which liquid would you like to fill your bottle with? ");

    //     }

    //     @Override
    //     public boolean isAvailable() {
            
    //         //create var
    //         boolean bottleInInventory = false;
    //         //loop thru junk sublist
    //         for (int i = 0; i < Data.player.sizeOfSubList(0); i++) {

    //             //if current item is a Bottle, bottleInInventory = true; otherwise do nothing
    //             if (Data.player.getItem(ItemType.JUNK, i).getClass() == Bottle.class) {

    //                 //set var to true
    //                 bottleInInventory = true;

    //             }

    //             //repeat loop until a Bottle is found (or not found)
    //         }

    //         //check if player is near a liquid AND if they have a Bottle in their inventory
    //         //if they satisfy both conditions, return true
    //         try {

    //             if (Data.nearLiquid.get(0) != null && bottleInInventory) { //if index 0 has nothing in it, there must'nt be anything in the other indexes either.
    
    //                 return true;
    
    //             }

    //         } catch (IndexOutOfBoundsException e) { //if the player is not near any liquids this will happen during the above if statement.

    //             return false;

    //         }

    //         return false; //if player is near a liquid and not in possesion of a Bottle

    //     }
    // },

    QUIT("Exit the game") {

        @Override
        public void opCode() {

            Data.player.quittingsUp(1);
            
            Data.continuingGame = Data.yesNoPrompt("Do you want to continue playing? [y/n] ", "y", "n");
            
        }

        @Override
        public boolean isAvailable() {
            return true;
        }
        
    };
    
    private String name;
    
    private Option(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This method is unique to every value in the Option enum, and when executed runs the code for that Option.
     * If the value in Option does not contain an opCode() method, a default message will be displayed.
     * This default message will never be displayed in the base game, and well-put-together mods should contain an opCode()
     * for every value in Option. If you (the player) are using mods, please consult with the mod's creator for support if you
     * see the default message. It would also wise to examine the code inside the Option enum, as it contains some very important functions.
     * Mod makers, please see the modding documentation at https://drewssite.top/jump-the-volcano/mods
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     */
    public void opCode() {
        System.out.println("WARNING: The option '" + this.getName() + "' option does not have any code yet.");
        System.out.println("It is reccomended to not use this Option as it doesn't do anything. If this Option is intentionally empty, then");
        System.out.println("add an empty opCode() method to this Option's enum value.");
        System.out.println();
    }

    /**
     * Returns true if the option should be displayed this turn, false otherwise.
     * Modders should create one of these for every option, or else the warning in the super implmentation will be displayed,
     * and the option will be displayed every turn.
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     */
    public boolean isAvailable() {
        System.out.println("WARNING: The option '" + this.getName() + "' does not have any availability code yet, availability defaulting to true.");
        System.out.println("If you would like to supress this message, add an empty isAvailable() method to the '" + this.getName() + "' option.");
        System.out.println();
        return true;
    }

}
