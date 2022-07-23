package top.drewssite.volcano.items;

/**
 * This class does not extend Item's capabilities in any way,
 * it simply provides a way to instantiate items without adding unneeded properties
 * @author foxler2010
 * @since v1.0
 * @see Item
 */
public class Miscellaneous extends Item {

    /** Constructs a new Miscellaneous item.
     * @author foxler2010
     * @param name The name of the Item
     * @since v1.0
     * @see Other
     */
    public Miscellaneous(String name) {

        super(name, ItemType.MISCELLANEOUS, false);

    }
    
}
