package accesoadatos;
import com.mysql.jdbc.Driver;
import java.sql.*;
public class ComunDB {


    private static String cadenaConexion = "jdbc:mysql://localhost:3306/GestionEmpleados?user=root&password=Darwin123456789!!";

    public static Connection obtenerConnection()throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(cadenaConexion);
        return connection;
    }
    public static PreparedStatement crearPreparedStatement(Connection connection, String sql) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    //Obtener y copiar los datos de la tabla-----------------
    public static ResultSet resultSet(PreparedStatement preparedStatement) throws SQLException{
        ResultSet resultSet = preparedStatement.executeQuery();
        return  resultSet;
    }
}
