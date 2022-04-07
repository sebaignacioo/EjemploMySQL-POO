package ejemplo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase intermedia entre la conexion a la BD y las personas almacenadas.
 * @author sebaignacioo
 */
public class PersonaBD {
    private Conexion conexion;
    
    /**
     * Genera un objeto de tipo PersonaBD que permite la interaccion con la BD.
     */
    public PersonaBD() {
        try {
            this.conexion = new Conexion("localhost", "testdb", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Obtiene un TreeMap con las personas almacenadas en la BD
     * @return un TreeMap con las personas
     */
    public TreeMap<String, Persona> getPersonas() {
        TreeMap<String, Persona> personas = new TreeMap<>();
        ResultSet rs = this.conexion.executeSelect("Persona");
        try {
            while (rs.next()) {
                personas.put(rs.getString("rut"), new Persona(
                        rs.getString("rut"),
                        rs.getString("nombres"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getString("email"),
                        rs.getInt("telefono")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    /**
     * Obtiene una persona segun su RUT
     * @param rut String con el RUT de la persona a buscar
     * @return Persona encontrada con ese RUT
     */
    public Persona getPersona(String rut) {
        return this.getPersonas().get(rut);
    }

    /**
     * Permite agregar una nueva persona a la BD.
     * @param persona Persona a ser agregada a la BD
     * @return Valor de verdad de la operacion.
     */
    public boolean insertPersona(Persona persona) {
        String sql = "INSERT INTO Persona (rut, nombres, apellido_paterno, apellido_materno, email, telefono) VALUES " +
                "(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = this.conexion.getConexion().prepareStatement(sql);
            statement.setString(1, persona.getRut());
            statement.setString(2, persona.getNombres());
            statement.setString(3, persona.getApPaterno());
            statement.setString(4, persona.getApMaterno());
            statement.setString(5, persona.getEmail());
            statement.setInt(6, persona.getTelefono());
            if (this.conexion.executeUpdate(statement) > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Permite actualizar a una persona de la BD
     * @param persona Persona a actualizar
     * @return Valor de verdad de la operacion.
     */
    public boolean updatePersona(Persona persona) {
        String sql = "UPDATE Persona SET nombres=?, apellido_paterno=?, apellido_materno=?, email=?, telefono=? WHERE" +
                " rut=?";
        try {
            PreparedStatement statement = this.conexion.getConexion().prepareStatement(sql);
            statement.setString(1, persona.getNombres());
            statement.setString(2, persona.getApPaterno());
            statement.setString(3, persona.getApMaterno());
            statement.setString(4, persona.getEmail());
            statement.setInt(5, persona.getTelefono());
            statement.setString(6, persona.getRut());
            if (this.conexion.executeUpdate(statement) > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Permite eliminar una persona de la BD segun su RUT.
     * @param rut RUT de la persona a eliminar
     * @return Persona eliminada
     */
    public Persona deletePersona(String rut) {
        Persona persona = this.getPersona(rut);
        if (persona == null) return null;
        String sql = "DELETE FROM Persona WHERE rut=?";
        try {
            PreparedStatement statement = this.conexion.getConexion().prepareStatement(sql);
            statement.setString(1, persona.getRut());
            if (this.conexion.executeUpdate(statement) > 0) return persona;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
