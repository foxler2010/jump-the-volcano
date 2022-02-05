# Modding the game

Hey! You might have read the code for the game and found I have made many comments about flexibility of the code and easy access to the game for modders.
This page attempts to describe how the game is designed with modding in mind, and how to create a basic mod.

<br>
<br>

PLEASE READ REST OF SECTION BELOW: I have not yet made an official first release of the game, with separate binaries for different platforms.
I am going to do that once I finish making the system for making Options and Items, and create all the base Options for the original game.

When I do the first release, I will split the game into two packages (Core and Data) and make a .jar file of the game along with binaries which I think will be
created with jlink and launch4j. (that may not be the way I do it. I still don't really have a plan for how I will package everything.)

The main "Core" package should not be modified by anyone but me, and the "Data" package may be modified by anyone who wants to make a mod for the game.
Additional packages may also be created and be used to contain mod data. I don't know how you would go about doing that, though.

Currently the best way to mod the game is to just edit the Data.java file within the top.drewssite.volcano package. Then recompile the game and distribute however you like.
Now go ahead and read the below guide.

## Understanding the structure of the game

Before we get into how to make a mod, you must understand how the game works. I will first describethe main loop,
and the then other classes that provide a sort of infrastruture for the main loop to sit on.

### WIP, going to write this later. contact me for help if you're making a mod.
