/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author y9d1ru
 */
public class DesCreador {
    public static void main(String[] args){
        try{
            JAXBContext jax = JAXBContext.newInstance(Perro.class);
            Unmarshaller pax = jax.createUnmarshaller();
            File XMLfile = new File("Book.xml");
            Perro perro = (Perro) pax.unmarshal(XMLfile);
            System.out.println(perro);
        } catch (JAXBException ex) {
            Logger.getLogger(DesCreador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}