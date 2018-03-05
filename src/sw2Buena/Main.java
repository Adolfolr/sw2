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

    public static void main(String[] args) {

        a = new Agenda();
        guardador = new Metodos("Agenda.xml");
        scanner = new Scanner(System.in);
        
        crearMenu();
    }

    public static void crearMenu() {
        System.out.println("1. Añadir contacto");
        System.out.println("2. Guardar");
        System.out.println("3. Importar agenda");
        System.out.println("4. Importar persona");
        System.out.println("5. Exportar persona");
        System.out.println("6. Contar personas en la agenda (XPath)");
        System.out.println("7. ¿Que personas tienen el telefono 1234?");
        System.out.println("8. Salir");
        int opcion = scanner.nextInt();
        comprobar(opcion);
    }

    public static void comprobar(int opcion) {
        switch (opcion) {
            case 1:
                crearContacto();
                break;
            case 2:
                guardar();
                break;
            case 3:
                importarAgenda();
                break;
            case 4:
                importarPersona();
                break;
            case 5:
                exportarPersona();
                break;
            case 6:
                evaluarXpath();
                break;
            case 7:
                xQueryEvaluador();
                break;
            case 8:
                System.exit(0);
        }
    }

    public static void xQueryEvaluador(){
        guardador.xQueryEvaluador("book.xml");
        crearMenu();
    }
    
    public static void evaluarXpath(){
        guardador.evaluarXpath("book.xml");
        crearMenu();
    }
    
    public static void guardar(){
        guardador.guardar(a);
        crearMenu();
    }
    
    
    public static void importarAgenda() {
        System.out.println("Nombre de la agenda que quieres importar:");
        String pwd = scanner.next();
        a = guardador.importar(pwd);
        crearMenu();
    }

    public static void exportarPersona() {
        int i = 1;
        for(Persona p : a.personas){
            System.out.println(i+". "+p.nombre);
            i++;
        }
        System.out.println("¿Qué contacto quieres exportar?");
        int opcion = scanner.nextInt();
        guardador.exportarPersona(a.personas.get(opcion - 1), a.personas.get(opcion - 1).nombre);
        crearMenu();
    }
    
    public static void importarPersona(){
        System.out.println("¿Qué persona quieres importar?(nombre completo del archivo)");
        String archivo = scanner.next();
        guardador.importarPersona(archivo);
        crearMenu();
    }

    public static void crearContacto() {
        System.out.println("Introduzca el nombre:");
        String nombre = scanner.next();
        String restriccionEmail = "[_\\-a-zA-z0-9\\.\\+]+@[a-zA-z0-9](\\.?[\\-a-zA-z0-9]*[a-zA-z0-9])*";
//        while(!nombre.matches("")){
//            System.out.println("Por favor, introduzca un nombre valido");
//            nombre = scanner.next();
//        }
//        nada, los nombres no tenían restricicones
        System.out.println("Introduzaca el numero de telefono:");
        String telefono = scanner.next();
        System.out.println("Introduzca el email:");
        String email = scanner.next();
        while(!email.matches(restriccionEmail) && email.length()<255){
            System.out.println("Por favor, introduzca un email válido");
            email = scanner.next();
        }
        Persona p = new Persona(nombre, telefono, email, false);
        a.anadirPersona(p);
        crearMenu();
    }
}
