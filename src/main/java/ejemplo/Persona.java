package ejemplo;

public class Persona {
    private String rut, nombres, apPaterno, apMaterno, email;
    private int telefono;

    public Persona(String rut, String nombres, String apPaterno, String apMaterno, String email, int telefono) {
        this.rut = rut;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String toPrint() {
        return String.format("%s %s %s // %9d // %s", this.apPaterno, this.apMaterno, this.nombres, this.telefono, this.email);
    }
    
}
