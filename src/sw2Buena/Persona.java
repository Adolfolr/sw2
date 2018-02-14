/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2Buena;

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
@XmlRootElement(name="Persona")
public class Persona implements Serializable{
    @XmlElement
    String nombre;
    @XmlElement    
    String telefono;
    @XmlElement
    String email;
    @XmlElement
    boolean bloqueado;
    
    public Persona(){
    }  

    public Persona(String nombre, String telefono, String email, boolean bloqueado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.bloqueado = bloqueado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    
    
    
}
