package accesoadatos;
import com.mysql.jdbc.Driver;
import java.sql.*;
public class ComunDB {
    private static String cadenaConexion = "jdbc:mysql://localhost:3306/empleados?user=root&password=Darwin123456789!!";

    public static Connection obtenerConexion() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexion = DriverManager.getConnection(cadenaConexion);
        return conexion;
    }

    public static PreparedStatement crearPreparedStatement(Connection conexion, String sql) throws SQLException{
        PreparedStatement ps = conexion.prepareStatement(sql);
        return ps;
    }

    public static ResultSet obtenerResultSet(PreparedStatement ps) throws SQLException{
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }
}