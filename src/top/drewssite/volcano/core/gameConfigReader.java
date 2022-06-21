package top.drewssite.volcano.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class gameConfigReader {

    private Path configDir;
    private File configFile;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;

    public gameConfigReader() {

        //create path and file objects
        this.configDir = Paths.get(System.getProperty("user.home"), ".config", "jump-the-volcano");
        this.configFile = new File(configDir.toString(), "gameConfig.xml");

        //initialize the factory
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            //use the factory to make a new DocumentBuilder
            this.documentBuilder = documentBuilderFactory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            
            System.err.println("ERROR: There is a critical error in the XML parser configuration.");
            e.printStackTrace();
            
        }

        try {
            //use the DocumentBuilder to parse the global config into a Document object
            this.document = documentBuilder.parse(this.configFile);

        } catch (SAXException e) {

            System.err.println("ERROR: There was a problem parsing the global configuration file. Please check your XML files for errors.");
            e.printStackTrace();

        } catch (IOException e) {

            System.err.println("ERROR: There was an error accessing the configuration file from your disk. Please make sure that the configuration file is accessible.");
            e.printStackTrace();

        }

    }    
}
