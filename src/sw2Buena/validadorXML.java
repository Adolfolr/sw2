/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2Buena;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 *
 * @author y9d1ru
 */
public class validadorXML {
    
    public void validarXML(File xml) {
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.out.println("primer1 error Validador");
                    exception.printStackTrace();
                }
                
                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.println("segundo2 error Validador");
                    exception.printStackTrace();
                }
                
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println("tercer3 error Validador");
                    exception.printStackTrace();
                }
            });
            try {
                Document doc = builder.parse(xml);
            } catch (SAXException ex) {
                    System.out.println("primer error Validador");                
                Logger.getLogger(validadorXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("segundo error Validador");
                Logger.getLogger(validadorXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            System.out.println("tercer error Validador");
            Logger.getLogger(validadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
