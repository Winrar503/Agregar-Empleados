package accesoadatos;

import entidadesdenegocio.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAL {
    public static ArrayList<Empleado> obtenerTodos() throws SQLException {
        ArrayList<Empleado> lista = new ArrayList<>();
        Empleado empleado;
        try{
            String sql = "SELECT Id, Nombre, Apellido, email, telefono FROM puesto";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ResultSet rs = ComunDB.obtenerResultSet(ps);
            while (rs.next()){
                empleado = new Empleado(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(empleado);
            }
            conexion.close();
            ps.close();
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  lista;
    }

    public static int guardar(Empleado empleado) throws SQLException{
        int result = 0;
        try {
            String sql = "INSERT INTO empleados(Nombre, Apellido, email, telefono, puesto) VALUES(?, ?, ?, ?, ?)";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getEmail());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getPuesto());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static int modificar(Empleado empleado) throws SQLException{
        int result = 0;
        try {
            String sql = "UPDATE empleados SET Nombre = ?,  Apellido = ?, Email = ?, Telefono = ?, Puesto = ? WHERE Id = ?";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getEmail());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getPuesto());
            ps.setInt(6, empleado.getId());

            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int eliminar(Empleado empleado) throws SQLException{
        int result = 0;
        try {
            String sql = "DELETE FROM empleados WHERE Id = ?";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setInt(1, empleado.getId());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Empleado> obtenerDatosFiltrados(Empleado empleados) throws SQLException{
        ArrayList<Empleado> lista = new ArrayList<>();
        Empleado est;
        try{
            String sql = "SELECT id,Nombre, Apellido, Email, Telefono, Puesto FROM empleados WHERE id = ? or apellido like'%" +
                    empleados.getApellido() + "%' or carrera like'%" +
                    empleados.getPuesto() + "%'";
            Connection connection = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(connection, sql);
            ps.setInt(1, empleados.getId());
            ResultSet rs = ComunDB.obtenerResultSet(ps);
            while (rs.next()){
                est = new Empleado(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(est);
            }
            connection.close();
            ps.close();
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
