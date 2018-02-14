/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2Buena;

import java.util.Scanner;

/**
 *
 * @author y9d1ru
 */
public class Main {
    
    static Agenda a;
    static Metodos guardador;
    static Scanner scanner;
    
    public static void main(String[] args){               
        
        a = new Agenda();
        guardador = new Metodos("Agenda.xml");
        scanner = new Scanner(System.in);
        guardador = new Metodos("Agenda.xml");
        crearMenu();
    }
    
    
    public static void crearMenu(){
        System.out.println("1. Añadir contacto");
        System.out.println("2. Guardar");
        System.out.println("3. Salir");
        int opcion = scanner.nextInt();
        comprobar(opcion);        
    }
    
    public static void comprobar(int opcion){
        switch(opcion){
            case 1:
                crearContacto();
                break;
            case 2:
                guardar();
                break;
            case 3:
                System.exit(0);
        }
    }
    
    public static void guardar(){
        guardador.guardar(a);
        crearMenu();
    }
    
    
    public static void crearContacto(){
        System.out.println("1. Nombre");
        String nombre = scanner.next();
        System.out.println("1. Telefono");
        String telefono = scanner.next();
        System.out.println("1. Email");
        String email = scanner.next();
        Persona p = new Persona(nombre, telefono, email, false);
        a.anadirPersona(p);
        crearMenu();
    }
}
