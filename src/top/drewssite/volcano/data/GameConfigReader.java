package top.drewssite.volcano.data;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class GameConfigReader {

    private Document document;

    /** Returns a new instance of GameConfigReader.
     * @author foxler2010
     * @return A new instance of GameConfigReader
     * @since v1.0
     * @see DataReader
     */
    public static GameConfigReader newInstance() {

        Path path = Paths.get(System.getProperty("user.home"), ".config", "jump-the-volcano");

        return new GameConfigReader(path);

    }

    private GameConfigReader(Path path) {

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

    }    
}
