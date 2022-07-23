package top.drewssite.volcano.items;

public class ConstructorNotDefinedException extends Exception {

    public ConstructorNotDefinedException(String typeName) {

        super("The " + typeName + " item type does not have a construct() method defined in ItemType!");

    }

}
