package ejemplo;

import java.util.Map;
import java.io.*;

/**
 * Ejemplo conexion con base de datos MySQL
 * @author sebaignacioo
 */
public class EjemploBD {

    /**
     * Metodo main
     * @param args 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        PersonaBD personasData = new PersonaBD();
        
        Map<String, Persona> personas = personasData.getPersonas();
        System.out.println("Mostrar personas: ");
        mostrarPersonas(personas);
        
        System.out.println("Agregar nueva persona:");
        Persona persona = insertarPersona(lector);
        if (personasData.insertPersona(persona)) System.out.println("Persona agregada");
        else System.out.println("Error agregando persona");
        
        System.out.println("Actualizando correo de persona");
        persona = actualizarPersona(lector, personasData);
        if (personasData.updatePersona(persona)) System.out.println("Persona actualizada");
        else System.out.println("Error actualizando persona");
        
        System.out.println("Eliminando persona");
        String rut = eliminarPersona(lector, personasData);
        if ((rut != null) && (personasData.deletePersona(rut) != null)) System.out.println("Persona eliminada");
        else System.out.println("Error eliminando persona");
        
    }
    
    /**
     * Permite mostrar el mapa de personas por pantalla
     * @param personas Personas a mostrar por pantalla
     */
    public static void mostrarPersonas(Map<String, Persona> personas) {
        for (Map.Entry<String, Persona> personasEntry: personas.entrySet()) {
            System.out.println(personasEntry.getValue().toPrint());
        }
    }
    
    /**
     * Permite la operacion de insercion de una nueva persona
     * @param lector BufferedReader con el lector de datos
     * @return Persona a agregar a la BD
     * @throws IOException Posibles errores de entrada y salida de datos
     */
    public static Persona insertarPersona(BufferedReader lector) throws IOException {
        System.out.print("Ingrese RUT de la persona: ");
        String rut = lector.readLine();
        System.out.print("Ingrese nombres de la persona: ");
        String nombres = lector.readLine();
        System.out.print("Ingrese apellido paterno de la persona: ");
        String apPat = lector.readLine();
        System.out.print("Ingrese apellido materno de la persona: ");
        String apMat = lector.readLine();
        System.out.print("Ingrese email de la persona: ");
        String email = lector.readLine();
        System.out.print("Ingrese telefono de la persona: ");
        int telefono = Integer.parseInt(lector.readLine());
        
        return new Persona(rut, nombres, apPat, apMat, email, telefono);        
    }
    
    /**
     * Permite la operacion de actualizacion de correo electronico de una persona
     * @param lector BufferedReader con el lector de datos
     * @param data Objeto PersonaBD con conexion a BD
     * @return Persona a actualizar
     * @throws IOException Posibles errores de entrada y salida de datos
     */
    public static Persona actualizarPersona(BufferedReader lector, PersonaBD data) throws IOException {
        System.out.print("Ingrese RUT de la persona: ");
        String rut = lector.readLine();
        System.out.print("Ingrese email de la persona: ");
        String email = lector.readLine();
        Persona persona = data.getPersona(rut);
        persona.setEmail(email);
        return persona;
    }
    
    /**
     * Permite la operacion de borrado de una persona de la BD
     * @param lector BufferedReader con el lector de datos
     * @param data Objeto PersonaBD con conexion a BD
     * @return RUT de la persona a eliminar
     * @throws IOException Posibles errores de entrada y salida de datos
     */
    public static String eliminarPersona(BufferedReader lector, PersonaBD data) throws IOException {
        System.out.print("Ingrese RUT de la persona: ");
        String rut = lector.readLine();
        
        Persona persona = data.getPersona(rut);
        if (persona != null) return rut;
        else return null;
    }
    
}
