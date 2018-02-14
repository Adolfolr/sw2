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

/**
 *
 * @author y9d1ru
 */
public class Creador {
    public static void main(String[] args){
        try {
            Perro perro = new Perro();
            perro.setNombre("jose");
            perro.setNumeroPatas(7);
            perro.setRaza("perrete");
            
            JAXBContext jaxbC = JAXBContext.newInstance(Perro.class);
            Marshaller jaxbM = jaxbC.createMarshaller();
            jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            File XMLfile=new File("Book.xml");
            jaxbM.marshal(perro, XMLfile);
            jaxbM.marshal(perro, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(Creador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
