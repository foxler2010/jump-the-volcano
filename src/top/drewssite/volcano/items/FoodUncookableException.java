package top.drewssite.volcano.items;

/**
 * This exception is thrown when you try to make an uncookable food cooked.
 * This can happen when constructing the item, or when changing its attributes via the setCookedness() method.
 * This exception should never occur to players unless there is a bug. The exception exists only to make sure that uncookable foods aren't cooked
 * @author foxler2010
 * @since v1.0
 * @see Food
 * */
public class FoodUncookableException extends Exception {

    /**
     * Constructs a new FoodUncookableException instance. This shouldn't need to be called by mod developers because the exception is only used within the Food class, and nowhere else.
     * @param foodName The name of the uncookable food. Used in the Food class when throwing the exception.
     * @author foxler2010
     * @since v1.0
     * @see FoodUncookableException
     * @see Food
     */
    public FoodUncookableException(String foodName) {

        super(foodName + " is uncookable!");

    }
    
}
