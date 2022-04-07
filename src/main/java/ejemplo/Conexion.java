package ejemplo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite realizar la conexion con la base de datos MySQL
 * @author sebaignacioo
 */
public class Conexion {
    
    private Connection conexion;
    
    /**
     * Permite construir un objeto conexion
     * @param host Host de la BD MySQL (localhost)
     * @param bd Base de datos a conectar (TestBD)
     * @param user Usuario de la BD MySQL (root)
     * @param pass Password del usuario de la BD MySQL (Vacio)
     * @throws SQLException Posibles errores de SQL
     */
    public Conexion(String host, String bd, String user, String pass) throws SQLException {
        String url = String.format("jdbc:mysql://%s/%s", host, bd);
        this.conexion = DriverManager.getConnection(url, user, pass);
    }

    /**
     * Permite obtener la conexion
     * @return Conexion
     */
    public Connection getConexion() {
        return conexion;
    }
    
    /**
     * Permite ejecutar una operacion de actualizacion de BD
     * @param ps Statement preparado para ejecutarse en la BD
     * @return Numero de filas afectadas en la operacion
     */
    public int executeUpdate(PreparedStatement ps) {
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    /**
     * Permite ejecutar una operacion de seleccion en la BD
     * @param tabla String con el nombre de la tabla a obtener los datos
     * @return ResultSet con el resultado de la operacion
     */
    public ResultSet executeSelect(String tabla) {
        try {
            String sql = String.format("SELECT * FROM %s", tabla);
            Statement statament = this.conexion.createStatement();
            return statament.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
