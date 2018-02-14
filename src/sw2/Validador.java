/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author y9d1ru
 */
public class Validador {
    public static void main(String[] args){
        try {
            File fXmlFile = new File("Book.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            System.out.println("Pero que suerte has tenido!");
        } catch (ParserConfigurationException ex) {
            System.out.println("GILIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        } catch (SAXException ex) {
            System.out.println("GILIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        } catch (IOException ex) {
            Logger.getLogger(Validador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
