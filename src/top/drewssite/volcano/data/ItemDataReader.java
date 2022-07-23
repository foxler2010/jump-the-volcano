package top.drewssite.volcano.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import top.drewssite.volcano.items.ConstructorNotDefinedException;
import top.drewssite.volcano.items.Item;
import top.drewssite.volcano.items.ItemType;

public class ItemDataReader {

    private Document document;
    private NodeList items;

    /** Returns a new instance of ItemDataReader.
     * @author foxler2010
     * @param dataFile The XML file that the ItemDataReader will access.
     * @return A new instance of ItemDataReader
     * @since v1.0
     * @see DataReader
     */
    public static ItemDataReader newInstance(Path path) {

        return new ItemDataReader(path);

    }

    private ItemDataReader(Path path) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;

        try {

            builder = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {

            System.err.println("ERROR: There is a critical error in the XML parser configuration.");
            e.printStackTrace();

        }

        try {

            this.document = builder.parse(path.toFile());

        } catch (IOException e) {
            
            System.err.println("ERROR: There was an error accessing the XML configuration document.");
            e.printStackTrace();

        } catch (SAXException e) {

            System.err.println("ERROR: There was an error parsing the XML configuration document");
            e.printStackTrace();

        }

        this.items = document.getElementsByTagName("item");

    }

    public Item getItem(String id) throws ConstructorNotDefinedException, ItemNotFoundException {

        //Determine which item we are constructing
        Element item = null;

        for (int i = 0; i < items.getLength(); i++) {

            Element currentItem = (Element) items.item(i);

            if (currentItem.getAttribute("id").equals(id)) { //only runs once since every ID is unique

                item = currentItem;

            }

        }

        if (item == null) {

            throw new ItemNotFoundException(id);

        }

        //Turn the item's type into an ItemType
        Element typeElement = (Element) item.getElementsByTagName("type").item(0);

        int typeId = Integer.parseInt(typeElement.getTextContent());

        ItemType type = null;

        for (int i = 0; i < ItemType.values().length; i++) {

            if (ItemType.values()[i].getIndex() == typeId) { //like above, this only runs once

                type = ItemType.values()[i];

            }

        }

        //fetch argument names
        ArrayList<String> args = type.getArgs();

        //replace argument names with the actual values that are stored in the XML data
        for (int i = 0; i < args.size(); i++) {

            //get value
            Element argValue = (Element) item.getElementsByTagName(args.get(i)).item(0);

            //replace name with fetched value
            args.set(i, argValue.getTextContent());

        }

        //use argument list as an argument for the item's construct() method.
        //the result is an Item, which is returned
        Item finalProduct = type.construct(args);

        return finalProduct;

    }

}
