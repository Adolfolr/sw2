/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2Buena;

import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import com.saxonica.xqj.SaxonXQDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;


/**
 *
 * @author y9d1ru
 */
public class Metodos {
    
    File agenda;
    validadorXML validador; //sisi, hay que ponerlo con mayus :(
    
    
    public Metodos(String nombre){
        
        agenda= new File(nombre);
        validador = new validadorXML();//sisi, hay que ponerlo con mayus :(
    }
    
    public void guardar(Agenda agenda){
        try {
            JAXBContext contexto = JAXBContext.newInstance(Agenda.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            File XMLfile=new File("Book.xml");
            marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
            "\n<!DOCTYPE Agenda [ \n<!ELEMENT Agenda (persona)*> \n" +
            "<!ELEMENT persona (nombre,telefono,email)>\n" +
            "<!ELEMENT nombre (#PCDATA)>\n" +
            "<!ELEMENT telefono (#PCDATA)>\n" +
            "<!ELEMENT email (#PCDATA)>\n ]>");
            marshaller.marshal(agenda, XMLfile);
            marshaller.marshal(agenda, System.out);
            validador.validarXML(XMLfile);
        } catch (JAXBException ex) {
            System.out.println("rayos y centellas!");
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Agenda importar(String nombre){
        try {
            File agenda = new File(nombre);
            JAXBContext jaxbC = JAXBContext.newInstance(Agenda.class);
            Unmarshaller jaxbU = jaxbC.createUnmarshaller();
            Agenda a = (Agenda) jaxbU.unmarshal(agenda);
            return a;
        } catch (JAXBException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void exportarPersona(Persona persona, String nombre){
        try {
            JAXBContext jaxbc = JAXBContext.newInstance(Persona.class);
            Marshaller m = jaxbc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File pers = new File(nombre+".xml");
            m.marshal(persona, pers);
        } catch (PropertyException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Persona importarPersona(String nombre){
        try {
            File persona = new File(nombre);
            JAXBContext jaxbc = JAXBContext.newInstance(Persona.class);
            Unmarshaller jaxbu = jaxbc.createUnmarshaller();
            Persona p = (Persona) jaxbu.unmarshal(persona);
            return p;
        } catch (JAXBException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static void evaluarXpath(String args) {
        File xmlFile = new File("book.xml");
        
        String expressionXPath = "count(//persona)";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            XPath xpath = XPathFactory.newInstance().newXPath();
            //Evaluate expression
            Double result = (Double) xpath.evaluate(expressionXPath, doc, XPathConstants.NUMBER);
            System.out.println("El resultado es " + result);
        } catch (org.xml.sax.SAXException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void xQueryEvaluador(String args) {
        try {
            //Try with different Querys Query_1, Query_2, ...
            File queryFile = new File("query.xqy"); //
        
            XQDataSource xqjd = new SaxonXQDataSource();
            XQConnection xqjc = xqjd.getConnection();
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(queryFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            XQPreparedExpression exp = xqjc.prepareExpression(inputStream);
            XQResultSequence result = exp.executeQuery();
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }
            result.close();
            exp.close();
            xqjc.close();

        } catch (XQException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}

