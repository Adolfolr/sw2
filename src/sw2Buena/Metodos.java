/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2Buena;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sw2.Perro;

/**
 *
 * @author y9d1ru
 */
public class Metodos {
    
    File agenda;
    
    public Metodos(String nombre){
        agenda= new File(nombre);
    }
    
    public void guardar(Agenda agenda){
        try {
            JAXBContext contexto = JAXBContext.newInstance(Agenda.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            File XMLfile=new File("Book.xml");
            marshaller.marshal(agenda, XMLfile);
            marshaller.marshal(agenda, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
