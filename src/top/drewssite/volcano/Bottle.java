package top.drewssite.volcano;

/**
 * This class implements Bottles, a way to store Liquids.
 * Originally, Bottles were part of the Junk class, but this class was created to add the extra
 * attributes required to store Liquids.
 * @author foxler2010
 * @since v1.0
 * @see Junk
 */
public class Bottle extends Junk {

    private int fullness;
    private Liquid contents;

    /**
     * The constructor for the Bottle class. The fullness and contents vars may be omitted if you wish to make the bottle empty; they will be set to 0 and null, respectively.
     * @author foxler2010
     * @param name  The name of the Bottle
     * @param price The price of the Bottle
     * @param fullness  How full the Bottle is
     * @param contents  What Liquid is stored inside the Bottle
     * @since v1.0
     * @see Junk
     */
    public Bottle(String name, double price, int fullness, Liquid contents) {

        super(name, price);

        this.fullness = fullness;
        this.contents = contents;

    }

    /**
     * The constructor for the Bottle class. The fullness and contents vars may be omitted if you wish to make the bottle empty; they will be set to 0 and null, respectively.
     * @param name The name of the Bottle
     * @param price The price of the Bottle
     * @author foxler2010
     * @since v1.0
     * @see Junk
     */
    public Bottle(String name, double price) {

        super(name, price);

        //empty bottle
        this.fullness = 0;
        this.contents = null;

    }

    /**
     * Returns the fullness of the Bottle
     * @author foxler2010
     * @return The fullness of the Bottle
     * @since v1.0
     * @see Junk
     */
    public int getFullness() {
        return fullness;
    }

    /**
     * Sets the fullness of the Bottle
     * @author foxler2010
     * @param fullness The fullness of the Bottle
     * @since v1.0
     * @see Junk
     */
    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    /**
     * Returns the contents of the Bottle
     * @author foxler2010
     * @return The contents of the Bottle
     * @since v1.0
     * @see Junk
     */
    public Liquid getContents() {
        return contents;
    }

    /**
     * Sets the contents of the Bottle
     * @author foxler2010
     * @param contents The contents of the Bottle
     * @since v1.0
     * @see Junk
     */
    public void setContents(Liquid contents) {
        this.contents = contents;
    }
    
}
