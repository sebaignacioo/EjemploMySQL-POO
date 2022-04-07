package ejemplo;

import java.util.Map;

/**
 * Ejemplo conexion con base de datos MySQL
 * @author sebaignacioo
 */
public class EjemploBD {

    /**
     * Metodo main
     * @param args 
     */
    public static void main(String[] args) {
        PersonaBD personasData = new PersonaBD();
        
        Map<String, Persona> personas = personasData.getPersonas();
        
        for (Map.Entry<String, Persona> personasEntry: personas.entrySet()) {
            System.out.println(personasEntry.getValue().toPrint());
        }
        
    }
}
