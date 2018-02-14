/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author y9d1ru
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Perro")
public class Perro implements Serializable{
    @XmlElement
    public String raza;
    @XmlElement
    public String nombre;
    @XmlElement
    public int numeroPatas;
    
    public Perro(){
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    
}
