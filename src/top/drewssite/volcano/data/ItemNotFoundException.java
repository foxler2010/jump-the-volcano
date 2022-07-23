package top.drewssite.volcano.data;

public class ItemNotFoundException extends Exception {
    
    public ItemNotFoundException(String id) {

        super("No item(s) with the ID: \"" + id + "\" were found in the XML data files");

    }

}
