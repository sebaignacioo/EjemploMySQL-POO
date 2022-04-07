package ejemplo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection conexion;
    
    public Conexion(String host, String bd, String user, String pass) throws SQLException {
        String url = String.format("jdbc:mysql://%s/%s", host, bd);
        this.conexion = DriverManager.getConnection(url, user, pass);
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public int executeUpdate(PreparedStatement ps) {
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
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
