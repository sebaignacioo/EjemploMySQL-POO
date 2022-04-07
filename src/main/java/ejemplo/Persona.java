package ejemplo;

/**
 * Clase modelo de persona
 * @author sebaignacioo
 */
public class Persona {
    private String rut, nombres, apPaterno, apMaterno, email;
    private int telefono;

    /**
     * Permite generar una persona
     * @param rut RUT de la persona
     * @param nombres Nombres de la persona
     * @param apPaterno Apellido paterno de la persona
     * @param apMaterno Apellido materno de la persona
     * @param email Correo electronico de la persona
     * @param telefono Telefono de la persona
     */
    public Persona(String rut, String nombres, String apPaterno, String apMaterno, String email, int telefono) {
        this.rut = rut;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * Permite obtener el RUT
     * @return RUT de la persona
     */
    public String getRut() {
        return rut;
    }

    /**
     * Permite modificar el RUt de la persona
     * @param rut RUT a modificar
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Permite obtener los nombres de la persona
     * @return Nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Permite modificar los nombres de la persona
     * @param nombres Nombres a modificar
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Permite obtener el apellido paterno de la persona
     * @return Apellido paterno de la persona
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * Permite modificar el apellido paterno de la persona.
     * @param apPaterno 
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * Permite obtener el apellido materno de la persona
     * @return Apellido materno de la persona
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * Permite modificar el apellido materno de la persona.
     * @param apMaterno apellido materno de la persona 
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    /**
     * Permite obtener el correo electronico de la persona
     * @return Correo electronico de la persona
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permite modificar el correo electronico de la persona
     * @param email Correo electronico a modificar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Permite obtener el telefono de la persona
     * @return Telefono de la persona
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Permite modificar el telefono de la persona
     * @param telefono Telefono a modificar
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Permite obtener un String para ser impreso por pantalla con los datos
     * de la persona
     * @return String printeable
     */
    public String toPrint() {
        return String.format("%s %s %s // %9d // %s", this.apPaterno, this.apMaterno, this.nombres, this.telefono, this.email);
    }
    
}
